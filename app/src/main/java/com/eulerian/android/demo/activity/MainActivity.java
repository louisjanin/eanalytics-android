package com.eulerian.android.demo.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.eulerian.android.demo.R;
import com.eulerian.android.sdk.EAnalytics;
import com.eulerian.android.sdk.model.EACart;
import com.eulerian.android.sdk.model.EAProduct;
import com.eulerian.android.sdk.model.EAProperties;


public class MainActivity extends ActionBarActivity {

    private double latitude = 48.871835;
    private double longitude = 2.382430;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickPurchase(View v) {
        EAProperties monAchat = new EAProperties.Builder()
                .set(EAProperties.KEY_GENERIC_FOR_PROPERTY_1, "aliens-\"vs\"-predator")
                .set(EAProperties.KEY_GENERIC_FOR_PROPERTY_1, "zorro")
                .set("my_special_key_because_I_am_Darty", "coca")
                .setLocation(latitude, longitude)
                .set("test-null", null)
                .build();
        EAnalytics.getInstance().track(monAchat);

//        RESULT:
//        {
//            "eos":"Android4.3",
//            "ea-key1":"aliens-\"vs\"-predator",
//            "ea-key2":"zorro",
//            "ea-appname":"com.eulerian.android.demo",
//            "my_special_key_because_I_am_Darty":"coca",
//            "test-null":"null",
//            "ea-lat":"48.871835",
//            "ea-lon":"2.38243",
//            "epoch":"1425809066805";
//            "property-type":"property",
//            "ehw":"Genymotion Google Nexus 4 - 4.3 - API 18 - 768x1280",
//            "euidl":"000000000000000",
//            "url":"http:\/\/com.eulerian.android.demo"
//        }
    }

    public void onClickGetProductDetails(View v) {
        EAProduct monProduit = new EAProduct.Builder()
                .setId("chaussure4314")
                .setPrice(50.34, "€")
                .setLocation(latitude, longitude)
                .build();

        EAnalytics.getInstance().track(monProduit);

        // RESULT
//        {
//            "eos":"Android4.3",
//            "ea-appname":"com.eulerian.android.demo",
//            "ea-currency":"€",
//            "ref-id":"chaussure4314",
//            "ea-price":"50.34",
//            "ea-lat":"48.871835",
//            "ea-lon":"2.38243",
//            "epoch":"1425809066805";
//            "property-type":"product",
//            "ehw":"Genymotion Google Nexus 4 - 4.3 - API 18 - 768x1280",
//            "euidl":"000000000000000",
//            "url":"http:\/\/com.eulerian.android.demo"
//        }
    }

    public void onClickAddToCart(View v) {
        EAProduct patesFraiches = new EAProduct.Builder()
                .setId("pates_barilla_extrem_quality-432444")
                .setPrice(5.23, "euros")
                .build();

        EAProduct lardons = new EAProduct.Builder()
                .setId("lardons_herta-4321")
                .setPrice(3.10, "euros")
                .build();

        EAProduct cremeFraiche = new EAProduct.Builder()
                .setId("creme_fraiche_de_la_laitière-240003")
                .setPrice(5.23, "euros")
                .build();

        EACart monPanier = new EACart.Builder()
                .addProductsToCart(patesFraiches, lardons)
                .addProductToCart(cremeFraiche)
                .setLocation(latitude, longitude)
                .build();

        EAnalytics.getInstance().track(monPanier);

        // RESULT:
//        {
//            "eos-type":"Android4.3",
//            "items":[
//                {
//                    "ea-currency":"euros",
//                    "ref-id":"pates_barilla_extrem_quality-432444",
//                    "ea-price":"5.23",
//                    "epoch":"1425812280643",
//                    "property-type":"product"
//                },
//                {
//                    "ea-currency":"euros",
//                    "ref-id":"lardons_herta-4321",
//                    "ea-price":"3.1",
//                    "epoch":"1425812280645",
//                    "property-type":"product"
//                },
//                {
//                    "ea-currency":"euros",
//                    "ref-id":"creme_fraiche_de_la_laitière-240003",
//                    "ea-price":"5.23",
//                    "epoch":"1425812280648",
//                    "property-type":"product"
//                }
//            ],
//            "ea-appname":"com.eulerian.android.demo",
//            "epoch":"1425812280650",
//            "ea-lat":"48.871835",
//            "ea-lon":"2.38243",
//            "ehw":"Genymotion Google Nexus 4 - 4.3 - API 18 - 768x1280",
//            "euidl":"000000000000000",
//            "url":"http:\/\/com.eulerian.android.demo",
//            "property-type":"cart"
//        }
    }

}
