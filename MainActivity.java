<html>
<head>
<title>MainActivity.java</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
.s0 { color: #cf8e6d;}
.s1 { color: #bcbec4;}
.s2 { color: #bcbec4;}
.s3 { color: #7a7e85;}
.s4 { color: #2aacb8;}
.s5 { color: #6aab73;}
</style>
</head>
<body bgcolor="#1e1f22">
<table CELLSPACING=0 CELLPADDING=5 COLS=1 WIDTH="100%" BGCOLOR="#606060" >
<tr><td><center>
<font face="Arial, Helvetica" color="#000000">
MainActivity.java</font>
</center></td></tr></table>
<pre><span class="s0">package </span><span class="s1">com</span><span class="s2">.</span><span class="s1">alpha</span><span class="s2">.</span><span class="s1">silentme</span><span class="s2">;</span>

<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">Manifest</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">app</span><span class="s2">.</span><span class="s1">PendingIntent</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">content</span><span class="s2">.</span><span class="s1">ComponentName</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">content</span><span class="s2">.</span><span class="s1">Context</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">content</span><span class="s2">.</span><span class="s1">Intent</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">content</span><span class="s2">.</span><span class="s1">ServiceConnection</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">content</span><span class="s2">.</span><span class="s1">pm</span><span class="s2">.</span><span class="s1">PackageManager</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">graphics</span><span class="s2">.</span><span class="s1">Color</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">location</span><span class="s2">.</span><span class="s1">Location</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">media</span><span class="s2">.</span><span class="s1">AudioManager</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">os</span><span class="s2">.</span><span class="s1">Build</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">os</span><span class="s2">.</span><span class="s1">Bundle</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">os</span><span class="s2">.</span><span class="s1">IBinder</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">util</span><span class="s2">.</span><span class="s1">Log</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">widget</span><span class="s2">.</span><span class="s1">ImageButton</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">widget</span><span class="s2">.</span><span class="s1">Toast</span><span class="s2">;</span>

<span class="s0">import </span><span class="s1">androidx</span><span class="s2">.</span><span class="s1">annotation</span><span class="s2">.</span><span class="s1">NonNull</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">androidx</span><span class="s2">.</span><span class="s1">appcompat</span><span class="s2">.</span><span class="s1">app</span><span class="s2">.</span><span class="s1">AppCompatActivity</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">androidx</span><span class="s2">.</span><span class="s1">core</span><span class="s2">.</span><span class="s1">app</span><span class="s2">.</span><span class="s1">ActivityCompat</span><span class="s2">;</span>

<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">alpha</span><span class="s2">.</span><span class="s1">silentme</span><span class="s2">.</span><span class="s1">R</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">android</span><span class="s2">.</span><span class="s1">gms</span><span class="s2">.</span><span class="s1">location</span><span class="s2">.</span><span class="s1">FusedLocationProviderClient</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">android</span><span class="s2">.</span><span class="s1">gms</span><span class="s2">.</span><span class="s1">location</span><span class="s2">.</span><span class="s1">Geofence</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">android</span><span class="s2">.</span><span class="s1">gms</span><span class="s2">.</span><span class="s1">location</span><span class="s2">.</span><span class="s1">GeofencingClient</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">android</span><span class="s2">.</span><span class="s1">gms</span><span class="s2">.</span><span class="s1">location</span><span class="s2">.</span><span class="s1">GeofencingRequest</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">android</span><span class="s2">.</span><span class="s1">gms</span><span class="s2">.</span><span class="s1">location</span><span class="s2">.</span><span class="s1">LocationServices</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">android</span><span class="s2">.</span><span class="s1">gms</span><span class="s2">.</span><span class="s1">maps</span><span class="s2">.</span><span class="s1">CameraUpdateFactory</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">android</span><span class="s2">.</span><span class="s1">gms</span><span class="s2">.</span><span class="s1">maps</span><span class="s2">.</span><span class="s1">GoogleMap</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">android</span><span class="s2">.</span><span class="s1">gms</span><span class="s2">.</span><span class="s1">maps</span><span class="s2">.</span><span class="s1">MapView</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">android</span><span class="s2">.</span><span class="s1">gms</span><span class="s2">.</span><span class="s1">maps</span><span class="s2">.</span><span class="s1">OnMapReadyCallback</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">android</span><span class="s2">.</span><span class="s1">gms</span><span class="s2">.</span><span class="s1">maps</span><span class="s2">.</span><span class="s1">model</span><span class="s2">.</span><span class="s1">Circle</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">android</span><span class="s2">.</span><span class="s1">gms</span><span class="s2">.</span><span class="s1">maps</span><span class="s2">.</span><span class="s1">model</span><span class="s2">.</span><span class="s1">CircleOptions</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">android</span><span class="s2">.</span><span class="s1">gms</span><span class="s2">.</span><span class="s1">maps</span><span class="s2">.</span><span class="s1">model</span><span class="s2">.</span><span class="s1">LatLng</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">android</span><span class="s2">.</span><span class="s1">gms</span><span class="s2">.</span><span class="s1">maps</span><span class="s2">.</span><span class="s1">model</span><span class="s2">.</span><span class="s1">Marker</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">android</span><span class="s2">.</span><span class="s1">gms</span><span class="s2">.</span><span class="s1">maps</span><span class="s2">.</span><span class="s1">model</span><span class="s2">.</span><span class="s1">MarkerOptions</span><span class="s2">;</span>

<span class="s0">public class </span><span class="s1">MainActivity </span><span class="s0">extends </span><span class="s1">AppCompatActivity </span><span class="s0">implements </span><span class="s1">OnMapReadyCallback</span><span class="s2">, </span><span class="s1">GoogleMap</span><span class="s2">.</span><span class="s1">OnMarkerDragListener </span><span class="s2">{</span>

    <span class="s0">private </span><span class="s1">MapView mapView</span><span class="s2">;</span>
    <span class="s0">private </span><span class="s1">GoogleMap googleMap</span><span class="s2">;</span>
    <span class="s0">private </span><span class="s1">GeofencingClient geofencingClient</span><span class="s2">;</span>
    <span class="s0">private </span><span class="s1">Marker marker</span><span class="s2">;</span>
    <span class="s0">private </span><span class="s1">Circle circle</span><span class="s2">;</span>
    <span class="s0">private </span><span class="s1">FusedLocationProviderClient fusedLocationClient</span><span class="s2">;</span>
    <span class="s0">private </span><span class="s1">LatLng centerLatLng</span><span class="s2">; </span><span class="s3">// Declare centerLatLng as an instance variable</span>
    <span class="s0">private float </span><span class="s1">radius</span><span class="s2">;</span>

    <span class="s0">private static final int </span><span class="s1">RINGER_MODE_VIBRATE </span><span class="s2">= </span><span class="s1">AudioManager</span><span class="s2">.</span><span class="s1">RINGER_MODE_VIBRATE</span><span class="s2">;</span>
    <span class="s0">private static final int </span><span class="s1">RINGER_MODE_NORMAL </span><span class="s2">= </span><span class="s1">AudioManager</span><span class="s2">.</span><span class="s1">RINGER_MODE_NORMAL</span><span class="s2">;</span>
    <span class="s0">private static final float </span><span class="s1">GEOFENCE_RADIUS </span><span class="s2">= </span><span class="s4">100</span><span class="s2">;</span>
    <span class="s0">private static final int </span><span class="s1">PERMISSIONS_REQUEST_FINE_LOCATION </span><span class="s2">= </span><span class="s4">123</span><span class="s2">;</span>
    <span class="s0">private static final int </span><span class="s1">PERMISSIONS_REQUEST_BACKGROUND_LOCATION </span><span class="s2">= </span><span class="s4">456</span><span class="s2">;</span>

    <span class="s0">private </span><span class="s1">GeofenceService geofenceService</span><span class="s2">;</span>
    <span class="s0">private boolean </span><span class="s1">isBound </span><span class="s2">= </span><span class="s0">false</span><span class="s2">;</span>

    <span class="s1">@Override</span>
    <span class="s0">protected void </span><span class="s1">onCreate</span><span class="s2">(</span><span class="s1">Bundle savedInstanceState</span><span class="s2">) {</span>
        <span class="s0">super</span><span class="s2">.</span><span class="s1">onCreate</span><span class="s2">(</span><span class="s1">savedInstanceState</span><span class="s2">);</span>
        <span class="s1">setContentView</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">layout</span><span class="s2">.</span><span class="s1">activity_main</span><span class="s2">);</span>
        <span class="s1">fusedLocationClient </span><span class="s2">= </span><span class="s1">LocationServices</span><span class="s2">.</span><span class="s1">getFusedLocationProviderClient</span><span class="s2">(</span><span class="s0">this</span><span class="s2">);</span>

<span class="s3">//        setVolumeToLowest();</span>

        <span class="s1">mapView </span><span class="s2">= </span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">mapView</span><span class="s2">);</span>
        <span class="s1">mapView</span><span class="s2">.</span><span class="s1">onCreate</span><span class="s2">(</span><span class="s1">savedInstanceState</span><span class="s2">);</span>
        <span class="s1">mapView</span><span class="s2">.</span><span class="s1">getMapAsync</span><span class="s2">(</span><span class="s0">this</span><span class="s2">);</span>

        <span class="s3">// Initialize the geofencing client</span>
        <span class="s1">geofencingClient </span><span class="s2">= </span><span class="s1">LocationServices</span><span class="s2">.</span><span class="s1">getGeofencingClient</span><span class="s2">(</span><span class="s0">this</span><span class="s2">);</span>

        <span class="s3">// Find the ImageButton and set its onClickListener</span>
        <span class="s1">ImageButton locationButton </span><span class="s2">= </span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">locationButton</span><span class="s2">);</span>
        <span class="s1">locationButton</span><span class="s2">.</span><span class="s1">setOnClickListener</span><span class="s2">(</span><span class="s1">v -&gt; onImageButtonClick</span><span class="s2">());</span>

        <span class="s3">// Check for background location permission</span>
        <span class="s0">if </span><span class="s2">(</span><span class="s1">ActivityCompat</span><span class="s2">.</span><span class="s1">checkSelfPermission</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s1">Manifest</span><span class="s2">.</span><span class="s1">permission</span><span class="s2">.</span><span class="s1">ACCESS_BACKGROUND_LOCATION</span><span class="s2">)</span>
                <span class="s2">!= </span><span class="s1">PackageManager</span><span class="s2">.</span><span class="s1">PERMISSION_GRANTED</span><span class="s2">) {</span>
            <span class="s3">// Request background location permission</span>
            <span class="s1">ActivityCompat</span><span class="s2">.</span><span class="s1">requestPermissions</span><span class="s2">(</span><span class="s0">this</span><span class="s2">,</span>
                    <span class="s0">new </span><span class="s1">String</span><span class="s2">[]{</span><span class="s1">Manifest</span><span class="s2">.</span><span class="s1">permission</span><span class="s2">.</span><span class="s1">ACCESS_BACKGROUND_LOCATION</span><span class="s2">},</span>
                    <span class="s1">PERMISSIONS_REQUEST_BACKGROUND_LOCATION</span><span class="s2">);</span>
        <span class="s2">} </span><span class="s0">else </span><span class="s2">{</span>
            <span class="s3">// Permission is already granted, proceed with setting up the geofence.</span>
            <span class="s1">setupGeofence</span><span class="s2">();</span>
        <span class="s2">}</span>
    <span class="s2">}</span>

    <span class="s0">private void </span><span class="s1">onImageButtonClick</span><span class="s2">() {</span>
        <span class="s0">if </span><span class="s2">(</span><span class="s1">ActivityCompat</span><span class="s2">.</span><span class="s1">checkSelfPermission</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s1">Manifest</span><span class="s2">.</span><span class="s1">permission</span><span class="s2">.</span><span class="s1">ACCESS_FINE_LOCATION</span><span class="s2">)</span>
                <span class="s2">!= </span><span class="s1">PackageManager</span><span class="s2">.</span><span class="s1">PERMISSION_GRANTED</span><span class="s2">) {</span>
            <span class="s3">// If the location permission is not granted, request it.</span>
            <span class="s1">ActivityCompat</span><span class="s2">.</span><span class="s1">requestPermissions</span><span class="s2">(</span><span class="s0">this</span><span class="s2">,</span>
                    <span class="s0">new </span><span class="s1">String</span><span class="s2">[]{</span><span class="s1">Manifest</span><span class="s2">.</span><span class="s1">permission</span><span class="s2">.</span><span class="s1">ACCESS_FINE_LOCATION</span><span class="s2">},</span>
                    <span class="s1">PERMISSIONS_REQUEST_FINE_LOCATION</span><span class="s2">);</span>
        <span class="s2">} </span><span class="s0">else </span><span class="s2">{</span>
            <span class="s3">// If the location permission is already granted, get the current location.</span>
            <span class="s1">getCurrentLocation</span><span class="s2">();</span>
        <span class="s2">}</span>
    <span class="s2">}</span>

    <span class="s0">private void </span><span class="s1">getCurrentLocation</span><span class="s2">() {</span>
        <span class="s0">if </span><span class="s2">(</span><span class="s1">ActivityCompat</span><span class="s2">.</span><span class="s1">checkSelfPermission</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s1">Manifest</span><span class="s2">.</span><span class="s1">permission</span><span class="s2">.</span><span class="s1">ACCESS_FINE_LOCATION</span><span class="s2">) != </span><span class="s1">PackageManager</span><span class="s2">.</span><span class="s1">PERMISSION_GRANTED </span><span class="s2">&amp;&amp; </span><span class="s1">ActivityCompat</span><span class="s2">.</span><span class="s1">checkSelfPermission</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s1">Manifest</span><span class="s2">.</span><span class="s1">permission</span><span class="s2">.</span><span class="s1">ACCESS_COARSE_LOCATION</span><span class="s2">) != </span><span class="s1">PackageManager</span><span class="s2">.</span><span class="s1">PERMISSION_GRANTED</span><span class="s2">) {</span>
            <span class="s3">// TODO: Consider calling ActivityCompat#requestPermissions here to request the missing permissions.</span>
            <span class="s0">return</span><span class="s2">;</span>
        <span class="s2">}</span>
        <span class="s1">fusedLocationClient</span><span class="s2">.</span><span class="s1">getLastLocation</span><span class="s2">()</span>
                <span class="s2">.</span><span class="s1">addOnSuccessListener</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s1">location -&gt; </span><span class="s2">{</span>
                    <span class="s0">if </span><span class="s2">(</span><span class="s1">location </span><span class="s2">!= </span><span class="s0">null</span><span class="s2">) {</span>
                        <span class="s1">LatLng currentLatLng </span><span class="s2">= </span><span class="s0">new </span><span class="s1">LatLng</span><span class="s2">(</span><span class="s1">location</span><span class="s2">.</span><span class="s1">getLatitude</span><span class="s2">(), </span><span class="s1">location</span><span class="s2">.</span><span class="s1">getLongitude</span><span class="s2">());</span>
                        <span class="s1">updateMarkerPosition</span><span class="s2">(</span><span class="s1">currentLatLng</span><span class="s2">);</span>
                        <span class="s1">moveCameraToLocation</span><span class="s2">(</span><span class="s1">currentLatLng</span><span class="s2">);</span>
                        <span class="s1">updateCirclePosition</span><span class="s2">(</span><span class="s1">currentLatLng</span><span class="s2">);</span>
                    <span class="s2">} </span><span class="s0">else </span><span class="s2">{</span>
                        <span class="s1">Toast</span><span class="s2">.</span><span class="s1">makeText</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s5">&quot;Failed to get current location&quot;</span><span class="s2">, </span><span class="s1">Toast</span><span class="s2">.</span><span class="s1">LENGTH_SHORT</span><span class="s2">).</span><span class="s1">show</span><span class="s2">();</span>
                    <span class="s2">}</span>
                <span class="s2">});</span>
    <span class="s2">}</span>

    <span class="s0">private void </span><span class="s1">updateMarkerPosition</span><span class="s2">(</span><span class="s1">LatLng newLocation</span><span class="s2">) {</span>

        <span class="s1">MySharedPreferences</span><span class="s2">.</span><span class="s1">saveString</span><span class="s2">(</span><span class="s0">this</span><span class="s2">,</span><span class="s5">&quot;Lat&quot;</span><span class="s2">,</span><span class="s1">String</span><span class="s2">.</span><span class="s1">valueOf</span><span class="s2">(</span><span class="s1">newLocation</span><span class="s2">.</span><span class="s1">latitude</span><span class="s2">));</span>
        <span class="s1">MySharedPreferences</span><span class="s2">.</span><span class="s1">saveString</span><span class="s2">(</span><span class="s0">this</span><span class="s2">,</span><span class="s5">&quot;Lng&quot;</span><span class="s2">,</span><span class="s1">String</span><span class="s2">.</span><span class="s1">valueOf</span><span class="s2">(</span><span class="s1">newLocation</span><span class="s2">.</span><span class="s1">longitude</span><span class="s2">));</span>
        <span class="s0">if </span><span class="s2">(</span><span class="s1">marker </span><span class="s2">!= </span><span class="s0">null</span><span class="s2">) {</span>
            <span class="s1">marker</span><span class="s2">.</span><span class="s1">setPosition</span><span class="s2">(</span><span class="s1">newLocation</span><span class="s2">);</span>
        <span class="s2">} </span><span class="s0">else </span><span class="s2">{</span>
            <span class="s3">// If the marker doesn't exist yet, create it.</span>
            <span class="s1">MarkerOptions markerOptions </span><span class="s2">= </span><span class="s0">new </span><span class="s1">MarkerOptions</span><span class="s2">().</span><span class="s1">position</span><span class="s2">(</span><span class="s1">newLocation</span><span class="s2">).</span><span class="s1">title</span><span class="s2">(</span><span class="s5">&quot;Marker Title&quot;</span><span class="s2">);</span>
            <span class="s1">marker </span><span class="s2">= </span><span class="s1">googleMap</span><span class="s2">.</span><span class="s1">addMarker</span><span class="s2">(</span><span class="s1">markerOptions</span><span class="s2">);</span>
            <span class="s1">marker</span><span class="s2">.</span><span class="s1">setDraggable</span><span class="s2">(</span><span class="s0">true</span><span class="s2">); </span><span class="s3">// Enable marker dragging</span>
            <span class="s1">googleMap</span><span class="s2">.</span><span class="s1">setOnMarkerDragListener</span><span class="s2">(</span><span class="s0">this</span><span class="s2">);</span>
        <span class="s2">}</span>
    <span class="s2">}</span>

    <span class="s0">private void </span><span class="s1">moveCameraToLocation</span><span class="s2">(</span><span class="s1">LatLng location</span><span class="s2">) {</span>
        <span class="s1">googleMap</span><span class="s2">.</span><span class="s1">animateCamera</span><span class="s2">(</span><span class="s1">CameraUpdateFactory</span><span class="s2">.</span><span class="s1">newLatLngZoom</span><span class="s2">(</span><span class="s1">location</span><span class="s2">, </span><span class="s4">17</span><span class="s2">));</span>
    <span class="s2">}</span>

    <span class="s0">private void </span><span class="s1">setVolumeToLowest</span><span class="s2">() {</span>
        <span class="s1">AudioManager audioManager </span><span class="s2">= (</span><span class="s1">AudioManager</span><span class="s2">) </span><span class="s1">getSystemService</span><span class="s2">(</span><span class="s1">Context</span><span class="s2">.</span><span class="s1">AUDIO_SERVICE</span><span class="s2">);</span>
        <span class="s0">if </span><span class="s2">(</span><span class="s1">audioManager </span><span class="s2">!= </span><span class="s0">null</span><span class="s2">) {</span>
            <span class="s0">int </span><span class="s1">lowestVolume </span><span class="s2">= </span><span class="s4">0</span><span class="s2">;</span>
            <span class="s0">if </span><span class="s2">(</span><span class="s1">Build</span><span class="s2">.</span><span class="s1">VERSION</span><span class="s2">.</span><span class="s1">SDK_INT </span><span class="s2">&gt;= </span><span class="s1">Build</span><span class="s2">.</span><span class="s1">VERSION_CODES</span><span class="s2">.</span><span class="s1">P</span><span class="s2">) {</span>
                <span class="s1">lowestVolume </span><span class="s2">= </span><span class="s1">audioManager</span><span class="s2">.</span><span class="s1">getStreamMinVolume</span><span class="s2">(</span><span class="s1">AudioManager</span><span class="s2">.</span><span class="s1">STREAM_RING</span><span class="s2">);</span>
            <span class="s2">}</span>
            <span class="s1">audioManager</span><span class="s2">.</span><span class="s1">setStreamVolume</span><span class="s2">(</span><span class="s1">AudioManager</span><span class="s2">.</span><span class="s1">STREAM_RING</span><span class="s2">, </span><span class="s1">lowestVolume</span><span class="s2">, </span><span class="s4">0</span><span class="s2">);</span>

            <span class="s3">// Set the device to vibrate mode</span>
            <span class="s1">audioManager</span><span class="s2">.</span><span class="s1">setRingerMode</span><span class="s2">(</span><span class="s1">AudioManager</span><span class="s2">.</span><span class="s1">RINGER_MODE_VIBRATE</span><span class="s2">);</span>
        <span class="s2">}</span>
    <span class="s2">}</span>

    <span class="s1">@Override</span>
    <span class="s0">public void </span><span class="s1">onRequestPermissionsResult</span><span class="s2">(</span><span class="s0">int </span><span class="s1">requestCode</span><span class="s2">, </span><span class="s1">@NonNull String</span><span class="s2">[] </span><span class="s1">permissions</span><span class="s2">, </span><span class="s1">@NonNull </span><span class="s0">int</span><span class="s2">[] </span><span class="s1">grantResults</span><span class="s2">) {</span>
        <span class="s0">super</span><span class="s2">.</span><span class="s1">onRequestPermissionsResult</span><span class="s2">(</span><span class="s1">requestCode</span><span class="s2">, </span><span class="s1">permissions</span><span class="s2">, </span><span class="s1">grantResults</span><span class="s2">);</span>
        <span class="s0">if </span><span class="s2">(</span><span class="s1">requestCode </span><span class="s2">== </span><span class="s1">PERMISSIONS_REQUEST_BACKGROUND_LOCATION</span><span class="s2">) {</span>
            <span class="s0">if </span><span class="s2">(</span><span class="s1">grantResults</span><span class="s2">.</span><span class="s1">length </span><span class="s2">&gt; </span><span class="s4">0 </span><span class="s2">&amp;&amp; </span><span class="s1">grantResults</span><span class="s2">[</span><span class="s4">0</span><span class="s2">] == </span><span class="s1">PackageManager</span><span class="s2">.</span><span class="s1">PERMISSION_GRANTED</span><span class="s2">) {</span>
                <span class="s3">// Background location permission granted, proceed with setting up the geofence.</span>
                <span class="s1">setupGeofence</span><span class="s2">();</span>
            <span class="s2">} </span><span class="s0">else </span><span class="s2">{</span>
                <span class="s3">// Background location permission denied, handle this situation (e.g., display a message or close the app).</span>
            <span class="s2">}</span>
        <span class="s2">}</span>
    <span class="s2">}</span>

    <span class="s0">private void </span><span class="s1">setupGeofence</span><span class="s2">() {</span>
        <span class="s3">// Add the geofence registration logic here</span>
        <span class="s3">// ...</span>
    <span class="s2">}</span>

    <span class="s1">@Override</span>
    <span class="s0">public void </span><span class="s1">onMapReady</span><span class="s2">(</span><span class="s1">@NonNull GoogleMap map</span><span class="s2">) {</span>
        <span class="s1">googleMap </span><span class="s2">= </span><span class="s1">map</span><span class="s2">;</span>

        <span class="s3">// Check for location permissions</span>
        <span class="s0">if </span><span class="s2">(</span><span class="s1">ActivityCompat</span><span class="s2">.</span><span class="s1">checkSelfPermission</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s1">Manifest</span><span class="s2">.</span><span class="s1">permission</span><span class="s2">.</span><span class="s1">ACCESS_FINE_LOCATION</span><span class="s2">)</span>
                <span class="s2">!= </span><span class="s1">PackageManager</span><span class="s2">.</span><span class="s1">PERMISSION_GRANTED</span>
                <span class="s2">&amp;&amp; </span><span class="s1">ActivityCompat</span><span class="s2">.</span><span class="s1">checkSelfPermission</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s1">Manifest</span><span class="s2">.</span><span class="s1">permission</span><span class="s2">.</span><span class="s1">ACCESS_COARSE_LOCATION</span><span class="s2">)</span>
                <span class="s2">!= </span><span class="s1">PackageManager</span><span class="s2">.</span><span class="s1">PERMISSION_GRANTED</span><span class="s2">) {</span>
            <span class="s3">// Request location permissions</span>
            <span class="s1">ActivityCompat</span><span class="s2">.</span><span class="s1">requestPermissions</span><span class="s2">(</span><span class="s0">this</span><span class="s2">,</span>
                    <span class="s0">new </span><span class="s1">String</span><span class="s2">[]{</span><span class="s1">Manifest</span><span class="s2">.</span><span class="s1">permission</span><span class="s2">.</span><span class="s1">ACCESS_FINE_LOCATION</span><span class="s2">, </span><span class="s1">Manifest</span><span class="s2">.</span><span class="s1">permission</span><span class="s2">.</span><span class="s1">ACCESS_COARSE_LOCATION</span><span class="s2">},</span>
                    <span class="s1">PERMISSIONS_REQUEST_FINE_LOCATION</span><span class="s2">);</span>
        <span class="s2">} </span><span class="s0">else </span><span class="s2">{</span>
            <span class="s3">// Permissions already granted, show the user's current location</span>
            <span class="s1">showUserCurrentLocation</span><span class="s2">();</span>
        <span class="s2">}</span>

        <span class="s1">String lat </span><span class="s2">= </span><span class="s1">MySharedPreferences</span><span class="s2">.</span><span class="s1">getString</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s5">&quot;Lat&quot;</span><span class="s2">);</span>
        <span class="s1">String lng </span><span class="s2">= </span><span class="s1">MySharedPreferences</span><span class="s2">.</span><span class="s1">getString</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s5">&quot;Lng&quot;</span><span class="s2">);</span>

        <span class="s0">if </span><span class="s2">(!</span><span class="s1">lat</span><span class="s2">.</span><span class="s1">isEmpty</span><span class="s2">())</span>
        <span class="s2">{</span>
            <span class="s3">// Add a marker to the desired initial location</span>
            <span class="s1">LatLng initialLocation </span><span class="s2">= </span><span class="s0">new </span><span class="s1">LatLng</span><span class="s2">(</span><span class="s1">Float</span><span class="s2">.</span><span class="s1">parseFloat</span><span class="s2">(</span><span class="s1">lat</span><span class="s2">), </span><span class="s1">Float</span><span class="s2">.</span><span class="s1">parseFloat</span><span class="s2">(</span><span class="s1">lng</span><span class="s2">));</span>
            <span class="s1">centerLatLng </span><span class="s2">= </span><span class="s1">initialLocation</span><span class="s2">;</span>
            <span class="s1">radius </span><span class="s2">= </span><span class="s4">100</span><span class="s2">;</span>
            <span class="s1">MarkerOptions markerOptions </span><span class="s2">= </span><span class="s0">new </span><span class="s1">MarkerOptions</span><span class="s2">().</span><span class="s1">position</span><span class="s2">(</span><span class="s1">initialLocation</span><span class="s2">).</span><span class="s1">title</span><span class="s2">(</span><span class="s5">&quot;My Marker&quot;</span><span class="s2">);</span>
            <span class="s1">marker </span><span class="s2">= </span><span class="s1">googleMap</span><span class="s2">.</span><span class="s1">addMarker</span><span class="s2">(</span><span class="s1">markerOptions</span><span class="s2">);</span>
            <span class="s1">marker</span><span class="s2">.</span><span class="s1">setDraggable</span><span class="s2">(</span><span class="s0">true</span><span class="s2">); </span><span class="s3">// Enable marker dragging</span>
            <span class="s1">googleMap</span><span class="s2">.</span><span class="s1">setOnMarkerDragListener</span><span class="s2">(</span><span class="s0">this</span><span class="s2">);</span>

            <span class="s3">// Move the camera to the initial marker location</span>
            <span class="s1">googleMap</span><span class="s2">.</span><span class="s1">moveCamera</span><span class="s2">(</span><span class="s1">CameraUpdateFactory</span><span class="s2">.</span><span class="s1">newLatLngZoom</span><span class="s2">(</span><span class="s1">initialLocation</span><span class="s2">, </span><span class="s4">17</span><span class="s2">));</span>

            <span class="s3">// Add a circle radius around the initial marker location</span>
            <span class="s1">CircleOptions circleOptions </span><span class="s2">= </span><span class="s0">new </span><span class="s1">CircleOptions</span><span class="s2">()</span>
                    <span class="s2">.</span><span class="s1">center</span><span class="s2">(</span><span class="s1">initialLocation</span><span class="s2">)</span>
                    <span class="s2">.</span><span class="s1">radius</span><span class="s2">(</span><span class="s4">100</span><span class="s2">) </span><span class="s3">// Radius in meters, change this value as per your requirement</span>
                    <span class="s2">.</span><span class="s1">strokeWidth</span><span class="s2">(</span><span class="s4">5f</span><span class="s2">)</span>
                    <span class="s2">.</span><span class="s1">strokeColor</span><span class="s2">(</span><span class="s1">Color</span><span class="s2">.</span><span class="s1">RED</span><span class="s2">)</span>
                    <span class="s2">.</span><span class="s1">fillColor</span><span class="s2">(</span><span class="s1">Color</span><span class="s2">.</span><span class="s1">parseColor</span><span class="s2">(</span><span class="s5">&quot;#30FF0000&quot;</span><span class="s2">)); </span><span class="s3">// Transparent red fill</span>

            <span class="s1">circle </span><span class="s2">= </span><span class="s1">googleMap</span><span class="s2">.</span><span class="s1">addCircle</span><span class="s2">(</span><span class="s1">circleOptions</span><span class="s2">);</span>

            <span class="s3">// Register the geofence with the selected location</span>
            <span class="s1">registerGeofence</span><span class="s2">(</span><span class="s1">initialLocation</span><span class="s2">, </span><span class="s4">100</span><span class="s2">);</span>

            <span class="s1">checkGeofenceStatus</span><span class="s2">();</span>
        <span class="s2">}</span>

    <span class="s2">}</span>

    <span class="s0">private void </span><span class="s1">showUserCurrentLocation</span><span class="s2">() {</span>
        <span class="s3">// Enable the &quot;My Location&quot; button on the map</span>
        <span class="s0">if </span><span class="s2">(</span><span class="s1">ActivityCompat</span><span class="s2">.</span><span class="s1">checkSelfPermission</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s1">Manifest</span><span class="s2">.</span><span class="s1">permission</span><span class="s2">.</span><span class="s1">ACCESS_FINE_LOCATION</span><span class="s2">) != </span><span class="s1">PackageManager</span><span class="s2">.</span><span class="s1">PERMISSION_GRANTED </span><span class="s2">&amp;&amp; </span><span class="s1">ActivityCompat</span><span class="s2">.</span><span class="s1">checkSelfPermission</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s1">Manifest</span><span class="s2">.</span><span class="s1">permission</span><span class="s2">.</span><span class="s1">ACCESS_COARSE_LOCATION</span><span class="s2">) != </span><span class="s1">PackageManager</span><span class="s2">.</span><span class="s1">PERMISSION_GRANTED</span><span class="s2">) {</span>
            <span class="s3">// TODO: Consider calling</span>
            <span class="s3">//    ActivityCompat#requestPermissions</span>
            <span class="s3">// here to request the missing permissions, and then overriding</span>
            <span class="s3">//   public void onRequestPermissionsResult(int requestCode, String[] permissions,</span>
            <span class="s3">//                                          int[] grantResults)</span>
            <span class="s3">// to handle the case where the user grants the permission. See the documentation</span>
            <span class="s3">// for ActivityCompat#requestPermissions for more details.</span>
            <span class="s0">return</span><span class="s2">;</span>
        <span class="s2">}</span>
        <span class="s1">googleMap</span><span class="s2">.</span><span class="s1">setMyLocationEnabled</span><span class="s2">(</span><span class="s0">true</span><span class="s2">);</span>

<span class="s3">//        // Get the user's current location</span>
<span class="s3">//        fusedLocationClient.getLastLocation()</span>
<span class="s3">//                .addOnSuccessListener(this, location -&gt; {</span>
<span class="s3">//                    if (location != null) {</span>
<span class="s3">//                        LatLng currentLatLng = new LatLng(location.getLatitude(), location.getLongitude());</span>
<span class="s3">//                        updateMarkerPosition(currentLatLng);</span>
<span class="s3">//                        moveCameraToLocation(currentLatLng);</span>
<span class="s3">//                        updateCirclePosition(currentLatLng);</span>
<span class="s3">//                        updateSilentMode(currentLatLng);</span>
<span class="s3">//                    } else {</span>
<span class="s3">//                        Toast.makeText(this, &quot;Failed to get current location&quot;, Toast.LENGTH_SHORT).show();</span>
<span class="s3">//                    }</span>
<span class="s3">//                });</span>
    <span class="s2">}</span>

<span class="s3">//    private void updateSilentMode(LatLng currentLatLng) {</span>
<span class="s3">//        String lat = MySharedPreferences.getString(this, &quot;Lat&quot;);</span>
<span class="s3">//        String lng = MySharedPreferences.getString(this, &quot;Lng&quot;);</span>
<span class="s3">//</span>
<span class="s3">//        float v = Float.parseFloat(lat);</span>
<span class="s3">//        float v1 = Float.parseFloat(lng);</span>
<span class="s3">//</span>
<span class="s3">//        float[] distance = new float[1];</span>
<span class="s3">//        Location.distanceBetween(currentLatLng.latitude, currentLatLng.longitude,</span>
<span class="s3">//                v, v1, distance);</span>
<span class="s3">//</span>
<span class="s3">////        Log.e(&quot;NewLogic&quot;,distance[0]+&quot;---&quot;);</span>
<span class="s3">//        if (distance[0] &gt; radius) {</span>
<span class="s3">//            // New location is outside the geofence radius, change to normal mode</span>
<span class="s3">//            setRingerMode(RINGER_MODE_NORMAL);</span>
<span class="s3">//        } else {</span>
<span class="s3">//            // New location is inside the geofence radius, change to vibrate mode</span>
<span class="s3">//            setRingerMode(RINGER_MODE_VIBRATE);</span>
<span class="s3">//        }</span>
<span class="s3">//</span>
<span class="s3">//    }</span>

    <span class="s1">@Override</span>
    <span class="s0">public void </span><span class="s1">onMarkerDragStart</span><span class="s2">(</span><span class="s1">Marker marker</span><span class="s2">) {</span>
        <span class="s3">// This method is called when you start dragging the marker.</span>
    <span class="s2">}</span>

    <span class="s1">@Override</span>
    <span class="s0">public void </span><span class="s1">onMarkerDrag</span><span class="s2">(</span><span class="s1">Marker marker</span><span class="s2">) {</span>
        <span class="s3">// This method is called as you drag the marker.</span>
    <span class="s2">}</span>

    <span class="s1">@Override</span>
    <span class="s0">public void </span><span class="s1">onMarkerDragEnd</span><span class="s2">(</span><span class="s1">Marker marker</span><span class="s2">) {</span>
        <span class="s1">LatLng newLocation </span><span class="s2">= </span><span class="s1">marker</span><span class="s2">.</span><span class="s1">getPosition</span><span class="s2">();</span>
        <span class="s1">updateGeofence</span><span class="s2">(</span><span class="s1">newLocation</span><span class="s2">);</span>
        <span class="s1">updateCirclePosition</span><span class="s2">(</span><span class="s1">newLocation</span><span class="s2">);</span>
        <span class="s1">updateMarkerPosition</span><span class="s2">(</span><span class="s1">newLocation</span><span class="s2">);</span>

    <span class="s2">}</span>


    <span class="s0">private void </span><span class="s1">checkGeofenceStatus</span><span class="s2">() {</span>
        <span class="s0">if </span><span class="s2">(</span><span class="s1">googleMap </span><span class="s2">!= </span><span class="s0">null </span><span class="s2">&amp;&amp; </span><span class="s1">centerLatLng </span><span class="s2">!= </span><span class="s0">null</span><span class="s2">) {</span>
            <span class="s0">float</span><span class="s2">[] </span><span class="s1">distance </span><span class="s2">= </span><span class="s0">new float</span><span class="s2">[</span><span class="s4">1</span><span class="s2">];</span>
            <span class="s1">Location</span><span class="s2">.</span><span class="s1">distanceBetween</span><span class="s2">(</span><span class="s1">centerLatLng</span><span class="s2">.</span><span class="s1">latitude</span><span class="s2">, </span><span class="s1">centerLatLng</span><span class="s2">.</span><span class="s1">longitude</span><span class="s2">,</span>
                    <span class="s1">centerLatLng</span><span class="s2">.</span><span class="s1">latitude</span><span class="s2">, </span><span class="s1">centerLatLng</span><span class="s2">.</span><span class="s1">longitude</span><span class="s2">, </span><span class="s1">distance</span><span class="s2">);</span>

            <span class="s0">boolean </span><span class="s1">insideGeofence </span><span class="s2">= </span><span class="s1">distance</span><span class="s2">[</span><span class="s4">0</span><span class="s2">] &lt;= </span><span class="s1">radius</span><span class="s2">;</span>

<span class="s3">//            // Set the ringer mode based on whether the user is inside or outside the geofence</span>
<span class="s3">//            if (insideGeofence) {</span>
<span class="s3">//                setRingerMode(RINGER_MODE_VIBRATE); // User is inside the geofence, set to vibrate mode</span>
<span class="s3">//            } else {</span>
<span class="s3">//                setRingerMode(RINGER_MODE_NORMAL); // User is outside the geofence, set to normal mode</span>
<span class="s3">//            }</span>

            <span class="s3">// Update the geofence status in the notification if the service is bound</span>
            <span class="s0">if </span><span class="s2">(</span><span class="s1">isBound</span><span class="s2">) {</span>
                <span class="s1">geofenceService</span><span class="s2">.</span><span class="s1">updateGeofenceStatus</span><span class="s2">(</span><span class="s1">insideGeofence</span><span class="s2">);</span>
            <span class="s2">}</span>
        <span class="s2">}</span>
    <span class="s2">}</span>


    <span class="s0">private void </span><span class="s1">setRingerMode</span><span class="s2">(</span><span class="s0">int </span><span class="s1">ringerMode</span><span class="s2">) {</span>
        <span class="s1">AudioManager audioManager </span><span class="s2">= (</span><span class="s1">AudioManager</span><span class="s2">) </span><span class="s1">getSystemService</span><span class="s2">(</span><span class="s1">Context</span><span class="s2">.</span><span class="s1">AUDIO_SERVICE</span><span class="s2">);</span>
        <span class="s0">if </span><span class="s2">(</span><span class="s1">audioManager </span><span class="s2">!= </span><span class="s0">null</span><span class="s2">) {</span>
            <span class="s1">audioManager</span><span class="s2">.</span><span class="s1">setRingerMode</span><span class="s2">(</span><span class="s1">ringerMode</span><span class="s2">);</span>
        <span class="s2">}</span>
    <span class="s2">}</span>

    <span class="s0">private void </span><span class="s1">updateCirclePosition</span><span class="s2">(</span><span class="s1">LatLng centerLatLng</span><span class="s2">) {</span>

        <span class="s0">if </span><span class="s2">(</span><span class="s1">googleMap </span><span class="s2">!= </span><span class="s0">null </span><span class="s2">&amp;&amp; </span><span class="s1">circle </span><span class="s2">!= </span><span class="s0">null</span><span class="s2">) {</span>
            <span class="s1">circle</span><span class="s2">.</span><span class="s1">setCenter</span><span class="s2">(</span><span class="s1">centerLatLng</span><span class="s2">);</span>
        <span class="s2">}</span>
    <span class="s2">}</span>

    <span class="s0">private void </span><span class="s1">registerGeofence</span><span class="s2">(</span><span class="s1">LatLng centerLatLng</span><span class="s2">, </span><span class="s0">float </span><span class="s1">radius</span><span class="s2">) {</span>
        <span class="s1">Geofence geofence </span><span class="s2">= </span><span class="s0">new </span><span class="s1">Geofence</span><span class="s2">.</span><span class="s1">Builder</span><span class="s2">()</span>
                <span class="s2">.</span><span class="s1">setRequestId</span><span class="s2">(</span><span class="s5">&quot;GEOFENCE_ID&quot;</span><span class="s2">)</span>
                <span class="s2">.</span><span class="s1">setCircularRegion</span><span class="s2">(</span><span class="s1">centerLatLng</span><span class="s2">.</span><span class="s1">latitude</span><span class="s2">, </span><span class="s1">centerLatLng</span><span class="s2">.</span><span class="s1">longitude</span><span class="s2">, </span><span class="s1">radius</span><span class="s2">)</span>
                <span class="s2">.</span><span class="s1">setTransitionTypes</span><span class="s2">(</span><span class="s1">Geofence</span><span class="s2">.</span><span class="s1">GEOFENCE_TRANSITION_ENTER </span><span class="s2">| </span><span class="s1">Geofence</span><span class="s2">.</span><span class="s1">GEOFENCE_TRANSITION_EXIT</span><span class="s2">)</span>
                <span class="s2">.</span><span class="s1">setExpirationDuration</span><span class="s2">(</span><span class="s1">Geofence</span><span class="s2">.</span><span class="s1">NEVER_EXPIRE</span><span class="s2">)</span>
                <span class="s2">.</span><span class="s1">build</span><span class="s2">();</span>

        <span class="s1">GeofencingRequest request </span><span class="s2">= </span><span class="s0">new </span><span class="s1">GeofencingRequest</span><span class="s2">.</span><span class="s1">Builder</span><span class="s2">()</span>
                <span class="s2">.</span><span class="s1">setInitialTrigger</span><span class="s2">(</span><span class="s1">GeofencingRequest</span><span class="s2">.</span><span class="s1">INITIAL_TRIGGER_ENTER</span><span class="s2">)</span>
                <span class="s2">.</span><span class="s1">addGeofence</span><span class="s2">(</span><span class="s1">geofence</span><span class="s2">)</span>
                <span class="s2">.</span><span class="s1">build</span><span class="s2">();</span>

        <span class="s3">// Update PendingIntent to include geofence transition type</span>
        <span class="s1">Intent geofenceIntent </span><span class="s2">= </span><span class="s0">new </span><span class="s1">Intent</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s1">GeofenceBroadcastReceiver</span><span class="s2">.</span><span class="s0">class</span><span class="s2">);</span>
        <span class="s1">geofenceIntent</span><span class="s2">.</span><span class="s1">setAction</span><span class="s2">(</span><span class="s5">&quot;com.alpha.silentme.ACTION_RECEIVE_GEOFENCE&quot;</span><span class="s2">);</span>
        <span class="s1">geofenceIntent</span><span class="s2">.</span><span class="s1">putExtra</span><span class="s2">(</span><span class="s5">&quot;geofenceTransition&quot;</span><span class="s2">, </span><span class="s1">Geofence</span><span class="s2">.</span><span class="s1">GEOFENCE_TRANSITION_EXIT</span><span class="s2">);</span>

        <span class="s1">PendingIntent pendingIntent </span><span class="s2">= </span><span class="s0">null</span><span class="s2">;</span>
        <span class="s0">int </span><span class="s1">flags</span><span class="s2">;</span>
        <span class="s0">if </span><span class="s2">(</span><span class="s1">Build</span><span class="s2">.</span><span class="s1">VERSION</span><span class="s2">.</span><span class="s1">SDK_INT </span><span class="s2">&lt; </span><span class="s1">Build</span><span class="s2">.</span><span class="s1">VERSION_CODES</span><span class="s2">.</span><span class="s1">S</span><span class="s2">) {</span>
            <span class="s1">flags </span><span class="s2">= </span><span class="s1">PendingIntent</span><span class="s2">.</span><span class="s1">FLAG_UPDATE_CURRENT</span><span class="s2">;</span>
        <span class="s2">} </span><span class="s0">else </span><span class="s2">{</span>
            <span class="s3">// Set the mutability flag for Android S and above</span>
            <span class="s1">flags </span><span class="s2">= </span><span class="s1">PendingIntent</span><span class="s2">.</span><span class="s1">FLAG_UPDATE_CURRENT </span><span class="s2">| </span><span class="s1">PendingIntent</span><span class="s2">.</span><span class="s1">FLAG_IMMUTABLE</span><span class="s2">;</span>
        <span class="s2">}</span>

        <span class="s1">pendingIntent </span><span class="s2">= </span><span class="s1">PendingIntent</span><span class="s2">.</span><span class="s1">getBroadcast</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s4">0</span><span class="s2">, </span><span class="s1">geofenceIntent</span><span class="s2">, </span><span class="s1">flags</span><span class="s2">);</span>
        <span class="s0">if </span><span class="s2">(</span><span class="s1">ActivityCompat</span><span class="s2">.</span><span class="s1">checkSelfPermission</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s1">Manifest</span><span class="s2">.</span><span class="s1">permission</span><span class="s2">.</span><span class="s1">ACCESS_FINE_LOCATION</span><span class="s2">) != </span><span class="s1">PackageManager</span><span class="s2">.</span><span class="s1">PERMISSION_GRANTED</span><span class="s2">) {</span>
            <span class="s3">// TODO: Consider calling</span>
            <span class="s3">//    ActivityCompat#requestPermissions</span>
            <span class="s3">// here to request the missing permissions, and then overriding</span>
            <span class="s3">//   public void onRequestPermissionsResult(int requestCode, String[] permissions,</span>
            <span class="s3">//                                          int[] grantResults)</span>
            <span class="s3">// to handle the case where the user grants the permission. See the documentation</span>
            <span class="s3">// for ActivityCompat#requestPermissions for more details.</span>
            <span class="s0">return</span><span class="s2">;</span>
        <span class="s2">}</span>
        <span class="s1">geofencingClient</span><span class="s2">.</span><span class="s1">addGeofences</span><span class="s2">(</span><span class="s1">request</span><span class="s2">, </span><span class="s1">pendingIntent</span><span class="s2">)</span>
                <span class="s2">.</span><span class="s1">addOnSuccessListener</span><span class="s2">(</span><span class="s1">aVoid -&gt; </span><span class="s2">{</span>
                    <span class="s3">// Geofence added successfully</span>
                    <span class="s1">Toast</span><span class="s2">.</span><span class="s1">makeText</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s5">&quot;Geofence registered!&quot;</span><span class="s2">, </span><span class="s1">Toast</span><span class="s2">.</span><span class="s1">LENGTH_SHORT</span><span class="s2">).</span><span class="s1">show</span><span class="s2">();</span>
                <span class="s2">})</span>
                <span class="s2">.</span><span class="s1">addOnFailureListener</span><span class="s2">(</span><span class="s1">e -&gt; </span><span class="s2">{</span>
                    <span class="s3">// Failed to add geofence</span>
                    <span class="s1">Toast</span><span class="s2">.</span><span class="s1">makeText</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s5">&quot;Failed to register geofence&quot;</span><span class="s2">, </span><span class="s1">Toast</span><span class="s2">.</span><span class="s1">LENGTH_SHORT</span><span class="s2">).</span><span class="s1">show</span><span class="s2">();</span>
                <span class="s2">});</span>
    <span class="s2">}</span>

    <span class="s0">private void </span><span class="s1">unregisterGeofence</span><span class="s2">() {</span>
        <span class="s1">geofencingClient</span><span class="s2">.</span><span class="s1">removeGeofences</span><span class="s2">(</span><span class="s1">getGeofencePendingIntent</span><span class="s2">());</span>
    <span class="s2">}</span>

    <span class="s0">private </span><span class="s1">PendingIntent getGeofencePendingIntent</span><span class="s2">() {</span>
        <span class="s1">Intent geofenceIntent </span><span class="s2">= </span><span class="s0">new </span><span class="s1">Intent</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s1">GeofenceBroadcastReceiver</span><span class="s2">.</span><span class="s0">class</span><span class="s2">);</span>
        <span class="s1">geofenceIntent</span><span class="s2">.</span><span class="s1">setAction</span><span class="s2">(</span><span class="s5">&quot;com.alpha.silentme.ACTION_RECEIVE_GEOFENCE&quot;</span><span class="s2">); </span><span class="s3">// Add the action to match the registered receiver</span>
        <span class="s0">int </span><span class="s1">flags</span><span class="s2">;</span>

        <span class="s3">// Use PendingIntent.getBroadcast for Android versions before Android S (API 31)</span>
        <span class="s0">if </span><span class="s2">(</span><span class="s1">Build</span><span class="s2">.</span><span class="s1">VERSION</span><span class="s2">.</span><span class="s1">SDK_INT </span><span class="s2">&lt; </span><span class="s1">Build</span><span class="s2">.</span><span class="s1">VERSION_CODES</span><span class="s2">.</span><span class="s1">S</span><span class="s2">) {</span>
            <span class="s1">flags </span><span class="s2">= </span><span class="s1">PendingIntent</span><span class="s2">.</span><span class="s1">FLAG_UPDATE_CURRENT</span><span class="s2">;</span>
        <span class="s2">} </span><span class="s0">else </span><span class="s2">{</span>
            <span class="s3">// Set the mutability flag for Android S and above</span>
            <span class="s1">flags </span><span class="s2">= </span><span class="s1">PendingIntent</span><span class="s2">.</span><span class="s1">FLAG_UPDATE_CURRENT </span><span class="s2">| </span><span class="s1">PendingIntent</span><span class="s2">.</span><span class="s1">FLAG_IMMUTABLE</span><span class="s2">;</span>
        <span class="s2">}</span>

        <span class="s0">return </span><span class="s1">PendingIntent</span><span class="s2">.</span><span class="s1">getBroadcast</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s4">0</span><span class="s2">, </span><span class="s1">geofenceIntent</span><span class="s2">, </span><span class="s1">flags</span><span class="s2">);</span>
    <span class="s2">}</span>

    <span class="s0">private void </span><span class="s1">updateGeofence</span><span class="s2">(</span><span class="s1">LatLng newLocation</span><span class="s2">) {</span>
        <span class="s1">unregisterGeofence</span><span class="s2">();</span>
        <span class="s1">centerLatLng </span><span class="s2">= </span><span class="s1">newLocation</span><span class="s2">; </span><span class="s3">// Update the centerLatLng with the new location</span>
        <span class="s1">registerGeofence</span><span class="s2">(</span><span class="s1">newLocation</span><span class="s2">, </span><span class="s1">GEOFENCE_RADIUS</span><span class="s2">);</span>
    <span class="s2">}</span>

    <span class="s1">@Override</span>
    <span class="s0">public void </span><span class="s1">onResume</span><span class="s2">() {</span>
        <span class="s0">super</span><span class="s2">.</span><span class="s1">onResume</span><span class="s2">();</span>
        <span class="s1">mapView</span><span class="s2">.</span><span class="s1">onResume</span><span class="s2">();</span>
        <span class="s1">bindGeofenceService</span><span class="s2">();</span>
    <span class="s2">}</span>

    <span class="s1">@Override</span>
    <span class="s0">public void </span><span class="s1">onPause</span><span class="s2">() {</span>
        <span class="s0">super</span><span class="s2">.</span><span class="s1">onPause</span><span class="s2">();</span>
        <span class="s1">mapView</span><span class="s2">.</span><span class="s1">onPause</span><span class="s2">();</span>
        <span class="s1">unbindGeofenceService</span><span class="s2">();</span>
    <span class="s2">}</span>

    <span class="s1">@Override</span>
    <span class="s0">public void </span><span class="s1">onDestroy</span><span class="s2">() {</span>
        <span class="s0">super</span><span class="s2">.</span><span class="s1">onDestroy</span><span class="s2">();</span>
        <span class="s1">mapView</span><span class="s2">.</span><span class="s1">onDestroy</span><span class="s2">();</span>
        <span class="s1">unbindGeofenceService</span><span class="s2">();</span>
    <span class="s2">}</span>

    <span class="s1">@Override</span>
    <span class="s0">public void </span><span class="s1">onLowMemory</span><span class="s2">() {</span>
        <span class="s0">super</span><span class="s2">.</span><span class="s1">onLowMemory</span><span class="s2">();</span>
        <span class="s1">mapView</span><span class="s2">.</span><span class="s1">onLowMemory</span><span class="s2">();</span>
    <span class="s2">}</span>

    <span class="s0">private void </span><span class="s1">bindGeofenceService</span><span class="s2">() {</span>
        <span class="s1">Intent intent </span><span class="s2">= </span><span class="s0">new </span><span class="s1">Intent</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s1">GeofenceService</span><span class="s2">.</span><span class="s0">class</span><span class="s2">);</span>
        <span class="s1">bindService</span><span class="s2">(</span><span class="s1">intent</span><span class="s2">, </span><span class="s1">serviceConnection</span><span class="s2">, </span><span class="s1">Context</span><span class="s2">.</span><span class="s1">BIND_AUTO_CREATE</span><span class="s2">);</span>
    <span class="s2">}</span>

    <span class="s0">private void </span><span class="s1">unbindGeofenceService</span><span class="s2">() {</span>
        <span class="s0">if </span><span class="s2">(</span><span class="s1">isBound</span><span class="s2">) {</span>
            <span class="s1">unbindService</span><span class="s2">(</span><span class="s1">serviceConnection</span><span class="s2">);</span>
            <span class="s1">isBound </span><span class="s2">= </span><span class="s0">false</span><span class="s2">;</span>
        <span class="s2">}</span>
    <span class="s2">}</span>

    <span class="s0">private final </span><span class="s1">ServiceConnection serviceConnection </span><span class="s2">= </span><span class="s0">new </span><span class="s1">ServiceConnection</span><span class="s2">() {</span>
        <span class="s1">@Override</span>
        <span class="s0">public void </span><span class="s1">onServiceConnected</span><span class="s2">(</span><span class="s1">ComponentName name</span><span class="s2">, </span><span class="s1">IBinder service</span><span class="s2">) {</span>
            <span class="s1">GeofenceService</span><span class="s2">.</span><span class="s1">GeofenceServiceBinder binder </span><span class="s2">= (</span><span class="s1">GeofenceService</span><span class="s2">.</span><span class="s1">GeofenceServiceBinder</span><span class="s2">) </span><span class="s1">service</span><span class="s2">;</span>
            <span class="s1">geofenceService </span><span class="s2">= </span><span class="s1">binder</span><span class="s2">.</span><span class="s1">getService</span><span class="s2">();</span>
            <span class="s1">isBound </span><span class="s2">= </span><span class="s0">true</span><span class="s2">;</span>
            <span class="s1">checkGeofenceStatus</span><span class="s2">(); </span><span class="s3">// Update geofence status when the service is connected</span>
        <span class="s2">}</span>

        <span class="s1">@Override</span>
        <span class="s0">public void </span><span class="s1">onServiceDisconnected</span><span class="s2">(</span><span class="s1">ComponentName name</span><span class="s2">) {</span>
            <span class="s1">isBound </span><span class="s2">= </span><span class="s0">false</span><span class="s2">;</span>
        <span class="s2">}</span>
    <span class="s2">};</span>

    <span class="s0">private void </span><span class="s1">setGeofenceStatus</span><span class="s2">(</span><span class="s0">boolean </span><span class="s1">insideGeofence</span><span class="s2">) {</span>
        <span class="s3">// Update your UI or notifications here based on the geofence status</span>
        <span class="s3">// For example, you can show a toast message indicating if the device is inside or outside the geofence.</span>
        <span class="s1">String message </span><span class="s2">= </span><span class="s1">insideGeofence </span><span class="s2">? </span><span class="s5">&quot;Inside Geofence&quot; </span><span class="s2">: </span><span class="s5">&quot;Outside Geofence&quot;</span><span class="s2">;</span>
        <span class="s1">Toast</span><span class="s2">.</span><span class="s1">makeText</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s1">message</span><span class="s2">, </span><span class="s1">Toast</span><span class="s2">.</span><span class="s1">LENGTH_SHORT</span><span class="s2">).</span><span class="s1">show</span><span class="s2">();</span>
    <span class="s2">}</span>
<span class="s2">}</span>
</pre>
</body>
</html>
