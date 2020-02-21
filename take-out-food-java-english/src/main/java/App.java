import java.util.ArrayList;
import java.util.List;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class App {
    private ItemRepository itemRepository;
    private SalesPromotionRepository salesPromotionRepository;

    public App(ItemRepository itemRepository, SalesPromotionRepository salesPromotionRepository) {
        this.itemRepository = itemRepository;
        this.salesPromotionRepository = salesPromotionRepository;
    }

    public String bestCharge(List<String> inputs) {
        String output = "";
        List<Item> orderedItem = new ArrayList<>();
        List<String> orderedItemIdList = new ArrayList<>();
        output += "============= Order details =============\n";
        for (String input : inputs) {

            String itemId = input.split("x")[0].trim();
            int count = Integer.parseInt(input.split("x")[1].trim());
            Item item = getItem(itemId);
            for (int i = 0; i < count; i++) {
                orderedItem.add(item);
            }
            orderedItemIdList.add(itemId);
            int orginalPrice = (int) (item.getPrice() * count);
            output += item.getName() + " x " + count + " = " + orginalPrice + " yuan\n";
        }


        int totalPrice = (int) getOrignalTotalPrice(orderedItem);
        int buy30Min6DiscountPrice = (int) (totalPrice - applyBuy30Min6Discount(orderedItem));
        int specialItemOfferPrice = (int) (totalPrice - applySpecialItemOffer(orderedItem));

        if ((applyBuy30Min6Discount(orderedItem) > 0) || applySpecialItemOffer(orderedItem) > 0) {
            output += "-----------------------------------\nPromotion used:\n";
            if (buy30Min6DiscountPrice <= specialItemOfferPrice) {
                output += getSalesPromotion("BUY_30_SAVE_6_YUAN").getDisplayName();
                output += "，saving " + (int) applyBuy30Min6Discount(orderedItem) + " yuan\n";
                output += "-----------------------------------\nTotal：" + buy30Min6DiscountPrice;
                output += " yuan\n===================================";
            } else {
                output += getSalesPromotion("50%_DISCOUNT_ON_SPECIFIED_ITEMS").getDisplayName();
                output += " (";
                List<String> nameList = new ArrayList<>();
                for (String str : getSalesPromotion("50%_DISCOUNT_ON_SPECIFIED_ITEMS").getRelatedItems()) {
                    if (orderedItemIdList.contains(str)) {
                        nameList.add(getItem(str).getName());
                    }
                }
                output += String.join("，", nameList);
                output += ")，saving " + (int) applySpecialItemOffer(orderedItem) + " yuan\n";
                output += "-----------------------------------\nTotal：" + specialItemOfferPrice;
                output += " yuan\n===================================";
            }
        } else {
            output += "-----------------------------------\nTotal：" + totalPrice;
            output += " yuan\n===================================";
        }


        return output;
    }

    //this method should be placed in ItemRepository
    private Item getItem(String itemId) {
        List<Item> itemList = itemRepository.findAll();
        for (Item item : itemList) {
            if (item.getId().equals(itemId)) {
                return item;
            }
        }
        return null;
    }

    private SalesPromotion getSalesPromotion(String promotionType) {
        List<SalesPromotion> salesPromotionList = salesPromotionRepository.findAll();
        for (SalesPromotion salesPromotion : salesPromotionList) {
            if (salesPromotion.getType().equals(promotionType)) {
                return salesPromotion;
            }
        }
        return null;
    }

    private double applyBuy30Min6Discount(List<Item> itemList) {
        double sum = 0.0;
        for (Item item : itemList) {
            sum += item.getPrice();
        }
        if (sum >= 30) {
            return 6.0;
        } else {
            return 0.0;
        }
    }

    private double applySpecialItemOffer(List<Item> itemList) {
        double discount = 0.0;
        for (Item item : itemList) {
            if (getSalesPromotion("50%_DISCOUNT_ON_SPECIFIED_ITEMS").getRelatedItems().contains(item.getId())) {
                double orignalPrice = item.getPrice();
                double reduce = orignalPrice / 2.0;
                discount += reduce;
            }
        }
        return discount;
    }

    private double getOrignalTotalPrice(List<Item> itemList) {
        double sum = 0.0;
        for (Item item : itemList) {
            sum += item.getPrice();
        }
        return sum;
    }
}
