package com.rong.flora.nov_09;


import java.util.HashMap;
import java.util.Map;

import static com.rong.flora.nov_09.Product.DRINK;
import static com.rong.flora.nov_09.HttpStatusCode.*;

/**
 * Created by  rong on 2016/11/9.
 */
public class Shopping implements IShopping {
    private String proName;
    private String merchant;

    public Shopping(String proName, String merchant){
        this.proName = proName;
        this.merchant = merchant;
    }

    /**
     * Various products to select:
     * 1. clothing
     * 2. food
     * 3. book
     * 4. drink
     * 5. cell phone
     * 6. laptop
     * ...
     * @return
     */
    public Integer select (Product product){
      return  product.getAmount();
    }


    public boolean pay(int amount, IOnComplete onComplete, IOnFailure onFailure){
        if (onComplete != null)
            onComplete.printReceipt(proName, merchant, amount);
        return true;

    }

    public static void main(String... args){
//        IShopping shop = new Shopping("op", "1");

        IShopping shopping = new IShopping() {
            @Override
            public Integer select(Product product) {
                return null;
            }

            @Override
            public boolean pay(int amount, IOnComplete onComplete, IOnFailure onFailure) {
                return false;
            }
        };

//        shop.pay(shop.select(DRINK), new IOnComplete() {
//                    @Override
//                    public void printReceipt(String prodName, String merchant, int amount) {
//                        System.out.println("prodName = " + prodName + "merchant =" + merchant + "amount =" + amount);
//                    }
//                },
//                new IOnFailure() {
//                    @Override
//                    public void cancelTransaction(int id, int amount, String merchant) {
//                        System.out.println("11.9");
//                    }
//                }
//        );
//
//        shop.pay(10000,
//                ((prodName, merchant, amount) -> System.out.println("prodName = "+ prodName + "merchant =" + merchant + "amount =" + amount)),
//                ((id, amount,merchant)-> System.out.println("trump")));
//
//        Map<String, Object> ret = new HashMap<>();
//
//        ret.put("error", FORBIDDEN);
//        ret.put("description", FORBIDDEN);
//        ret.put("ok", OK);
//System.out.println(ret);
    }
}
