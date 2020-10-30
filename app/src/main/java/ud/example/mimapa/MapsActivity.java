package ud.example.mimapa;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import android.widget.CheckBox;
import android.widget.Toast;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, OnMapClickListener {
    private GoogleMap mMap;
    private final LatLng SAN = new LatLng(12.587151, -81698713);
    private LocationManager locationManager;
    private LocationListener locationListener;
    private LatLng miUbicacion;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                miUbicacion=new LatLng(location.getLongitude(), (location.getLatitude()));
            }
        };
        RePermisos();
        }

    private void RePermisos() {
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED)
            requestPermissions(new String[]{
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION}, 101);
        else{
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,locationListener);
        }
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
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.setOnMapClickListener((GoogleMap.OnMapClickListener)this);
    }

    public void MapaNormal(View v) {
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    public void MapaSatelite(View v) {
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }

    public void moveCamara(View v) {
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SAN, 15));
    }

    public void irParaiso(View v) {
        LatLng paraiso = new LatLng(4.6313895,-74.071227);
        Marker miMaker = mMap.addMarker(new MarkerOptions().position(paraiso).title("casaFea").snippet("casaBEtty"));
        miMaker.showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(paraiso,10));
    }

    public void Limpiar(View v) {
        mMap.clear();
    }

    public void mostraUD(View v) {
        LatLng UD = new LatLng(4.6281045, -74.0654527);
        Marker miMaker = mMap.addMarker(new MarkerOptions().position(UD).title("UD").snippet("UNIVERSIDAD DISTRITAL"));
        miMaker.showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UD, 10));
    }

    public void addMarker(View v) {
        if(checkBox =1;) {
            LatLng temlating = mMap.getCameraPosition().target;

            mMap.addMarker(new MarkerOptions().position(temlating).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        }
    }

    public void mostrarmiubicacion(View v) {
        try {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(miUbicacion, 10));
        } catch (Exception ex) {
        }
    }


    @Override
    public void onMapClick(LatLng latLng) {
        mMap.addMarker(new MarkerOptions().position(latLng));
    }
}

