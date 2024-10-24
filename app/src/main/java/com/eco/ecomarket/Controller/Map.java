package com.eco.ecomarket.Controller;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.eco.ecomarket.R;
import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.map.MapObjectCollection;
import com.yandex.mapkit.map.PlacemarkMapObject;
import com.yandex.mapkit.mapview.MapView;
import com.yandex.runtime.image.ImageProvider;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Map extends AppCompatActivity {
    MapView mapView;
    List<Point> points;
    ImageProvider imageProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        MapKitFactory.setApiKey("70bf1709-25c6-479d-8a72-7534a2967fd1");
        MapKitFactory.initialize(this);
        setContentView(R.layout.activity_map);
        initWidget();

//       MapObjectCollection pinsCollection= mapView.getMap().getMapObjects();
//
//           for (Point point : points) {
//            PlacemarkMapObject place=pinsCollection.addPlacemark();
//            place.setGeometry(point);
//            place.setIcon(imageProvider);
//        }

              mapView.getMap().move(new CameraPosition(new Point(51.123330, 71.434386),01.0f,0.0f,0.0f),
                new Animation(Animation.Type.SMOOTH,10f),null);

    }

    private void initWidget() {
        mapView=findViewById(R.id.mapView);
        points= Arrays.asList(
                new Point(51.098186, 71.399313),
                new Point(51.148668, 71.435954),
                new Point(51.129723, 71.477783)
        );
        imageProvider = ImageProvider.fromResource(this, R.drawable.ic_ecology);

    }

    @Override
    protected void onStop() {
        mapView.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    @Override
    protected void onStart() {
        mapView.onStart();
        MapKitFactory.getInstance().onStart();
        super.onStart();
    }
}