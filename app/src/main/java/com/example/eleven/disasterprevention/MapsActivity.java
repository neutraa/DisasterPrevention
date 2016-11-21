package com.example.eleven.disasterprevention;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.kml.*;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng Aizu = new LatLng(37.506804, 139.930531);
        try {
        KmlLayer kmlLayer = new KmlLayer(googleMap, R.raw.aizu_evac_flood, getApplicationContext());
        kmlLayer.addLayerToMap();

            Iterable containers = kmlLayer.getContainers();
            //for (KmlPlacemark placemark : kmlLayer.getPlacemarks()) {
            /*for (KmlContainer container : kmlLayer.getContainers()) {
                Log.d("Test", "タップされました");
                System.out.println("Tapped");
                if (container.hasProperty("description")) {
                    Log.d("Test", "タップされました");
                    System.out.println("Tapped");
                    //System.out.println(placemark.getProperty("latitude"));
                    //}
                }
            }*/
            for (KmlContainer container : kmlLayer.getContainers()) {
                String brabra = " ";
                //if (placemark.hasProperty("P20_001")) {
                if(container.hasProperty("latitude")){
                brabra = container.getProperty("latitude");
                }


                mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        // TODO Auto-generated method stub
                        Log.d("テスト","中身は");

                        Toast.makeText(getApplicationContext(), "Tapped", Toast.LENGTH_LONG).show();
                        return false;
                        }
                    });

                Log.d("Test1","ンアッーーーーーーーーーーーーーーーーーーー！！！！！！！！");
                Log.d("Test2","ンアッーーーーーーーーーーーーーーーーーーー！！！！！！！！");
                Log.d("Test3","ンアッーーーーーーーーーーーーーーーーーーー！！！！！！！！");
                Log.d("Test4","ンアッーーーーーーーーーーーーーーーーーーー！！！！！！！！");
                Log.d("Test5","ンアッーーーーーーーーーーーーーーーーーーー！！！！！！！！");
                Log.d("Test6","ンアッーーーーーーーーーーーーーーーーーーー！！！！！！！！");
                Log.d("Test7","ンアッーーーーーーーーーーーーーーーーーーー！！！！！！！！");

                    //System.out.println(placemark.getProperty("latitude"));
                //}
            }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Aizu, 15));
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void open_browser(){
        String base = "http://www.http://chilitsumo.com/diary/android-browser-launcher"; //URLの文字列
        Uri uri = Uri.parse(base);//URIにParse
        Intent i = new Intent(Intent.ACTION_VIEW,uri);
        i.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
        //androidの標準ブラウザのクラスをセット
        startActivity(i);//明示的インテントでアクティビティの起動
    }


}
