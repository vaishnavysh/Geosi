<html>
<head>
<title>GeofenceService.java</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
.s0 { color: #cf8e6d;}
.s1 { color: #bcbec4;}
.s2 { color: #bcbec4;}
.s3 { color: #2aacb8;}
.s4 { color: #6aab73;}
.s5 { color: #7a7e85;}
</style>
</head>
<body bgcolor="#1e1f22">
<table CELLSPACING=0 CELLPADDING=5 COLS=1 WIDTH="100%" BGCOLOR="#606060" >
<tr><td><center>
<font face="Arial, Helvetica" color="#000000">
GeofenceService.java</font>
</center></td></tr></table>
<pre><span class="s0">package </span><span class="s1">com</span><span class="s2">.</span><span class="s1">alpha</span><span class="s2">.</span><span class="s1">silentme</span><span class="s2">;</span>

<span class="s0">import static </span><span class="s1">android</span><span class="s2">.</span><span class="s1">media</span><span class="s2">.</span><span class="s1">AudioManager</span><span class="s2">.</span><span class="s1">RINGER_MODE_NORMAL</span><span class="s2">;</span>
<span class="s0">import static </span><span class="s1">android</span><span class="s2">.</span><span class="s1">media</span><span class="s2">.</span><span class="s1">AudioManager</span><span class="s2">.</span><span class="s1">RINGER_MODE_VIBRATE</span><span class="s2">;</span>

<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">annotation</span><span class="s2">.</span><span class="s1">SuppressLint</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">app</span><span class="s2">.</span><span class="s1">Notification</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">app</span><span class="s2">.</span><span class="s1">NotificationChannel</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">app</span><span class="s2">.</span><span class="s1">NotificationManager</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">app</span><span class="s2">.</span><span class="s1">PendingIntent</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">app</span><span class="s2">.</span><span class="s1">Service</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">content</span><span class="s2">.</span><span class="s1">ComponentName</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">content</span><span class="s2">.</span><span class="s1">Context</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">content</span><span class="s2">.</span><span class="s1">Intent</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">content</span><span class="s2">.</span><span class="s1">pm</span><span class="s2">.</span><span class="s1">PackageManager</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">graphics</span><span class="s2">.</span><span class="s1">Color</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">location</span><span class="s2">.</span><span class="s1">Location</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">media</span><span class="s2">.</span><span class="s1">AudioManager</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">os</span><span class="s2">.</span><span class="s1">Build</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">os</span><span class="s2">.</span><span class="s1">IBinder</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">os</span><span class="s2">.</span><span class="s1">IBinder</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">os</span><span class="s2">.</span><span class="s1">Binder</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">os</span><span class="s2">.</span><span class="s1">Looper</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">util</span><span class="s2">.</span><span class="s1">Log</span><span class="s2">;</span>

<span class="s0">import </span><span class="s1">androidx</span><span class="s2">.</span><span class="s1">annotation</span><span class="s2">.</span><span class="s1">Nullable</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">androidx</span><span class="s2">.</span><span class="s1">core</span><span class="s2">.</span><span class="s1">app</span><span class="s2">.</span><span class="s1">ActivityCompat</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">androidx</span><span class="s2">.</span><span class="s1">core</span><span class="s2">.</span><span class="s1">app</span><span class="s2">.</span><span class="s1">NotificationCompat</span><span class="s2">;</span>

<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">android</span><span class="s2">.</span><span class="s1">gms</span><span class="s2">.</span><span class="s1">location</span><span class="s2">.</span><span class="s1">FusedLocationProviderClient</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">android</span><span class="s2">.</span><span class="s1">gms</span><span class="s2">.</span><span class="s1">location</span><span class="s2">.</span><span class="s1">LocationCallback</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">android</span><span class="s2">.</span><span class="s1">gms</span><span class="s2">.</span><span class="s1">location</span><span class="s2">.</span><span class="s1">LocationRequest</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">android</span><span class="s2">.</span><span class="s1">gms</span><span class="s2">.</span><span class="s1">location</span><span class="s2">.</span><span class="s1">LocationResult</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">android</span><span class="s2">.</span><span class="s1">gms</span><span class="s2">.</span><span class="s1">location</span><span class="s2">.</span><span class="s1">LocationServices</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">android</span><span class="s2">.</span><span class="s1">gms</span><span class="s2">.</span><span class="s1">location</span><span class="s2">.</span><span class="s1">Priority</span><span class="s2">;</span>

<span class="s0">public class </span><span class="s1">GeofenceService </span><span class="s0">extends </span><span class="s1">Service </span><span class="s2">{</span>

    <span class="s0">private static final int </span><span class="s1">NOTIFICATION_ID </span><span class="s2">= </span><span class="s3">123</span><span class="s2">;</span>
    <span class="s0">private static final </span><span class="s1">String NOTIFICATION_CHANNEL_ID </span><span class="s2">= </span><span class="s4">&quot;GeofenceChannel&quot;</span><span class="s2">;</span>
    <span class="s0">private static final </span><span class="s1">String GEOFENCE_STATUS_ENTERED </span><span class="s2">= </span><span class="s4">&quot;Inside the geofence area&quot;</span><span class="s2">;</span>
    <span class="s0">private static final </span><span class="s1">String GEOFENCE_STATUS_EXITED </span><span class="s2">= </span><span class="s4">&quot;Outside the geofence area&quot;</span><span class="s2">;</span>

    <span class="s0">private final </span><span class="s1">IBinder binder </span><span class="s2">= </span><span class="s0">new </span><span class="s1">GeofenceServiceBinder</span><span class="s2">();</span>

    <span class="s0">private </span><span class="s1">FusedLocationProviderClient fusedLocationProviderClient</span><span class="s2">;</span>

    <span class="s1">@SuppressLint</span><span class="s2">(</span><span class="s4">&quot;ForegroundServiceType&quot;</span><span class="s2">)</span>
    <span class="s1">@Override</span>
    <span class="s0">public int </span><span class="s1">onStartCommand</span><span class="s2">(</span><span class="s1">Intent intent</span><span class="s2">, </span><span class="s0">int </span><span class="s1">flags</span><span class="s2">, </span><span class="s0">int </span><span class="s1">startId</span><span class="s2">) {</span>
        <span class="s5">// Start the service as a foreground service</span>
        <span class="s1">startForeground</span><span class="s2">(</span><span class="s1">NOTIFICATION_ID</span><span class="s2">, </span><span class="s1">createNotification</span><span class="s2">(</span><span class="s1">GEOFENCE_STATUS_EXITED</span><span class="s2">));</span>
        <span class="s0">return </span><span class="s1">START_STICKY</span><span class="s2">;</span>
    <span class="s2">}</span>


    <span class="s0">private void </span><span class="s1">startLocationUpdates</span><span class="s2">() {</span>
        <span class="s0">if </span><span class="s2">(</span><span class="s1">ActivityCompat</span><span class="s2">.</span><span class="s1">checkSelfPermission</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s1">android</span><span class="s2">.</span><span class="s1">Manifest</span><span class="s2">.</span><span class="s1">permission</span><span class="s2">.</span><span class="s1">ACCESS_FINE_LOCATION</span><span class="s2">) != </span><span class="s1">PackageManager</span><span class="s2">.</span><span class="s1">PERMISSION_GRANTED </span><span class="s2">&amp;&amp; </span><span class="s1">ActivityCompat</span><span class="s2">.</span><span class="s1">checkSelfPermission</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s1">android</span><span class="s2">.</span><span class="s1">Manifest</span><span class="s2">.</span><span class="s1">permission</span><span class="s2">.</span><span class="s1">ACCESS_COARSE_LOCATION</span><span class="s2">) != </span><span class="s1">PackageManager</span><span class="s2">.</span><span class="s1">PERMISSION_GRANTED</span><span class="s2">) {</span>
            <span class="s5">// TODO: Consider calling</span>
            <span class="s5">//    ActivityCompat#requestPermissions</span>
            <span class="s5">// here to request the missing permissions, and then overriding</span>
            <span class="s5">//   public void onRequestPermissionsResult(int requestCode, String[] permissions,</span>
            <span class="s5">//                                          int[] grantResults)</span>
            <span class="s5">// to handle the case where the user grants the permission. See the documentation</span>
            <span class="s5">// for ActivityCompat#requestPermissions for more details.</span>
            <span class="s0">return</span><span class="s2">;</span>
        <span class="s2">}</span>
        <span class="s1">fusedLocationProviderClient</span><span class="s2">.</span><span class="s1">requestLocationUpdates</span><span class="s2">(</span><span class="s1">locationRequest</span><span class="s2">,</span>
                <span class="s1">locationCallback</span><span class="s2">,</span>
                <span class="s1">Looper</span><span class="s2">.</span><span class="s1">getMainLooper</span><span class="s2">());</span>
    <span class="s2">}</span>

    <span class="s0">private </span><span class="s1">LocationRequest locationRequest</span><span class="s2">;</span>
    <span class="s0">private </span><span class="s1">LocationCallback locationCallback</span><span class="s2">;</span>

    <span class="s1">@Override</span>
    <span class="s0">public void </span><span class="s1">onCreate</span><span class="s2">() {</span>
        <span class="s0">super</span><span class="s2">.</span><span class="s1">onCreate</span><span class="s2">();</span>


        <span class="s5">// Initialize FusedLocationProviderClient</span>
        <span class="s1">fusedLocationProviderClient </span><span class="s2">= </span><span class="s1">LocationServices</span><span class="s2">.</span><span class="s1">getFusedLocationProviderClient</span><span class="s2">(</span><span class="s0">this</span><span class="s2">);</span>

        <span class="s5">// Configure location request using builder pattern</span>
        <span class="s1">locationRequest </span><span class="s2">= </span><span class="s0">new </span><span class="s1">LocationRequest</span><span class="s2">.</span><span class="s1">Builder</span><span class="s2">(</span><span class="s1">Priority</span><span class="s2">.</span><span class="s1">PRIORITY_HIGH_ACCURACY</span><span class="s2">, </span><span class="s3">100</span><span class="s2">)</span>
                <span class="s2">.</span><span class="s1">setWaitForAccurateLocation</span><span class="s2">(</span><span class="s0">false</span><span class="s2">)</span>
                <span class="s2">.</span><span class="s1">setMinUpdateIntervalMillis</span><span class="s2">(</span><span class="s3">2000</span><span class="s2">)</span>
                <span class="s2">.</span><span class="s1">setMaxUpdateDelayMillis</span><span class="s2">(</span><span class="s3">100</span><span class="s2">)</span>
                <span class="s2">.</span><span class="s1">build</span><span class="s2">();</span>

        <span class="s1">locationCallback </span><span class="s2">= </span><span class="s0">new </span><span class="s1">LocationCallback</span><span class="s2">() {</span>
            <span class="s1">@Override</span>
            <span class="s0">public void </span><span class="s1">onLocationResult</span><span class="s2">(</span><span class="s1">LocationResult locationResult</span><span class="s2">) {</span>
                <span class="s0">if </span><span class="s2">(</span><span class="s1">locationResult </span><span class="s2">== </span><span class="s0">null</span><span class="s2">) {</span>
                    <span class="s0">return</span><span class="s2">;</span>
                <span class="s2">}</span>
                <span class="s0">for </span><span class="s2">(</span><span class="s1">Location location </span><span class="s2">: </span><span class="s1">locationResult</span><span class="s2">.</span><span class="s1">getLocations</span><span class="s2">()) {</span>
                    <span class="s5">// Update UI with location data</span>
                    <span class="s1">Location lastLocation </span><span class="s2">= </span><span class="s1">locationResult</span><span class="s2">.</span><span class="s1">getLastLocation</span><span class="s2">();</span>
                    <span class="s1">String lat </span><span class="s2">= </span><span class="s1">MySharedPreferences</span><span class="s2">.</span><span class="s1">getString</span><span class="s2">(</span><span class="s1">getApplicationContext</span><span class="s2">(), </span><span class="s4">&quot;Lat&quot;</span><span class="s2">);</span>
                    <span class="s1">String lng </span><span class="s2">= </span><span class="s1">MySharedPreferences</span><span class="s2">.</span><span class="s1">getString</span><span class="s2">(</span><span class="s1">getApplicationContext</span><span class="s2">(), </span><span class="s4">&quot;Lng&quot;</span><span class="s2">);</span>


                    <span class="s0">if</span><span class="s2">(!</span><span class="s1">lat</span><span class="s2">.</span><span class="s1">isEmpty</span><span class="s2">())</span>
                    <span class="s2">{</span>
                        <span class="s1">Log</span><span class="s2">.</span><span class="s1">e</span><span class="s2">(</span><span class="s4">&quot;SettLocation:&quot;</span><span class="s2">,</span><span class="s1">lat</span><span class="s2">+</span><span class="s4">&quot;---&quot;</span><span class="s2">+</span><span class="s1">lng</span><span class="s2">);</span>
                        <span class="s0">float </span><span class="s1">v </span><span class="s2">= </span><span class="s1">Float</span><span class="s2">.</span><span class="s1">parseFloat</span><span class="s2">(</span><span class="s1">lat</span><span class="s2">);</span>
                        <span class="s0">float </span><span class="s1">v1 </span><span class="s2">= </span><span class="s1">Float</span><span class="s2">.</span><span class="s1">parseFloat</span><span class="s2">(</span><span class="s1">lng</span><span class="s2">);</span>

                        <span class="s0">float</span><span class="s2">[] </span><span class="s1">distance </span><span class="s2">= </span><span class="s0">new float</span><span class="s2">[</span><span class="s3">1</span><span class="s2">];</span>
                        <span class="s1">Location</span><span class="s2">.</span><span class="s1">distanceBetween</span><span class="s2">(</span><span class="s1">lastLocation</span><span class="s2">.</span><span class="s1">getLatitude</span><span class="s2">(), </span><span class="s1">lastLocation</span><span class="s2">.</span><span class="s1">getLongitude</span><span class="s2">(),</span>
                                <span class="s1">v</span><span class="s2">, </span><span class="s1">v1</span><span class="s2">, </span><span class="s1">distance</span><span class="s2">);</span>

                        <span class="s1">Log</span><span class="s2">.</span><span class="s1">e</span><span class="s2">(</span><span class="s4">&quot;NewLogic&quot;</span><span class="s2">,</span><span class="s1">distance</span><span class="s2">[</span><span class="s3">0</span><span class="s2">]+</span><span class="s4">&quot;---&quot;</span><span class="s2">);</span>
                        <span class="s0">if </span><span class="s2">(</span><span class="s1">distance</span><span class="s2">[</span><span class="s3">0</span><span class="s2">] &gt; </span><span class="s3">100</span><span class="s2">) {</span>
                            <span class="s5">// New location is outside the geofence radius, change to normal mode</span>
                            <span class="s1">setRingerMode</span><span class="s2">(</span><span class="s1">RINGER_MODE_NORMAL</span><span class="s2">);</span>
                        <span class="s2">} </span><span class="s0">else </span><span class="s2">{</span>
                            <span class="s5">// New location is inside the geofence radius, change to vibrate mode</span>
                            <span class="s1">setRingerMode</span><span class="s2">(</span><span class="s1">RINGER_MODE_VIBRATE</span><span class="s2">);</span>
                        <span class="s2">}</span>

                    <span class="s2">}</span>


                    <span class="s5">// ...</span>
                <span class="s2">}</span>
            <span class="s2">}</span>
        <span class="s2">};</span>


        <span class="s5">// Request location updates</span>
        <span class="s0">if </span><span class="s2">(</span><span class="s1">ActivityCompat</span><span class="s2">.</span><span class="s1">checkSelfPermission</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s1">android</span><span class="s2">.</span><span class="s1">Manifest</span><span class="s2">.</span><span class="s1">permission</span><span class="s2">.</span><span class="s1">ACCESS_FINE_LOCATION</span><span class="s2">) != </span><span class="s1">PackageManager</span><span class="s2">.</span><span class="s1">PERMISSION_GRANTED </span><span class="s2">&amp;&amp; </span><span class="s1">ActivityCompat</span><span class="s2">.</span><span class="s1">checkSelfPermission</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s1">android</span><span class="s2">.</span><span class="s1">Manifest</span><span class="s2">.</span><span class="s1">permission</span><span class="s2">.</span><span class="s1">ACCESS_COARSE_LOCATION</span><span class="s2">) != </span><span class="s1">PackageManager</span><span class="s2">.</span><span class="s1">PERMISSION_GRANTED</span><span class="s2">) {</span>
            <span class="s5">// TODO: Consider calling</span>
            <span class="s5">//    ActivityCompat#requestPermissions</span>
            <span class="s5">// here to request the missing permissions, and then overriding</span>
            <span class="s5">//   public void onRequestPermissionsResult(int requestCode, String[] permissions,</span>
            <span class="s5">//                                          int[] grantResults)</span>
            <span class="s5">// to handle the case where the user grants the permission. See the documentation</span>
            <span class="s5">// for ActivityCompat#requestPermissions for more details.</span>
            <span class="s0">return</span><span class="s2">;</span>
        <span class="s2">}</span>
        <span class="s1">fusedLocationProviderClient</span><span class="s2">.</span><span class="s1">requestLocationUpdates</span><span class="s2">(</span><span class="s1">locationRequest</span><span class="s2">, </span><span class="s1">locationCallback</span><span class="s2">, </span><span class="s0">null</span><span class="s2">);</span>
    <span class="s2">}</span>

    <span class="s0">private void </span><span class="s1">setRingerMode</span><span class="s2">(</span><span class="s0">int </span><span class="s1">ringerMode</span><span class="s2">) {</span>
        <span class="s1">AudioManager audioManager </span><span class="s2">= (</span><span class="s1">AudioManager</span><span class="s2">) </span><span class="s1">getSystemService</span><span class="s2">(</span><span class="s1">Context</span><span class="s2">.</span><span class="s1">AUDIO_SERVICE</span><span class="s2">);</span>
        <span class="s0">if </span><span class="s2">(</span><span class="s1">audioManager </span><span class="s2">!= </span><span class="s0">null</span><span class="s2">) {</span>
            <span class="s1">audioManager</span><span class="s2">.</span><span class="s1">setRingerMode</span><span class="s2">(</span><span class="s1">ringerMode</span><span class="s2">);</span>
        <span class="s2">}</span>
    <span class="s2">}</span>


    <span class="s1">@Override</span>
    <span class="s0">public void </span><span class="s1">onDestroy</span><span class="s2">() {</span>
        <span class="s0">super</span><span class="s2">.</span><span class="s1">onDestroy</span><span class="s2">();</span>
    <span class="s2">}</span>

    <span class="s1">@Nullable</span>
    <span class="s1">@Override</span>
    <span class="s0">public </span><span class="s1">IBinder onBind</span><span class="s2">(</span><span class="s1">Intent intent</span><span class="s2">) {</span>
        <span class="s0">return </span><span class="s1">binder</span><span class="s2">;</span>
    <span class="s2">}</span>

    <span class="s0">public class </span><span class="s1">GeofenceServiceBinder </span><span class="s0">extends </span><span class="s1">Binder </span><span class="s2">{</span>
        <span class="s1">GeofenceService getService</span><span class="s2">() {</span>
            <span class="s0">return </span><span class="s1">GeofenceService</span><span class="s2">.</span><span class="s0">this</span><span class="s2">;</span>
        <span class="s2">}</span>
    <span class="s2">}</span>

    <span class="s0">private </span><span class="s1">Notification createNotification</span><span class="s2">(</span><span class="s1">String geofenceStatus</span><span class="s2">) {</span>
        <span class="s5">// Create a notification channel for Android Oreo and above</span>
        <span class="s0">if </span><span class="s2">(</span><span class="s1">Build</span><span class="s2">.</span><span class="s1">VERSION</span><span class="s2">.</span><span class="s1">SDK_INT </span><span class="s2">&gt;= </span><span class="s1">Build</span><span class="s2">.</span><span class="s1">VERSION_CODES</span><span class="s2">.</span><span class="s1">O</span><span class="s2">) {</span>
            <span class="s1">NotificationChannel channel </span><span class="s2">= </span><span class="s0">new </span><span class="s1">NotificationChannel</span><span class="s2">(</span>
                    <span class="s1">NOTIFICATION_CHANNEL_ID</span><span class="s2">,</span>
                    <span class="s4">&quot;Geofence Service Channel&quot;</span><span class="s2">,</span>
                    <span class="s1">NotificationManager</span><span class="s2">.</span><span class="s1">IMPORTANCE_DEFAULT</span>
            <span class="s2">);</span>

            <span class="s1">NotificationManager notificationManager </span><span class="s2">= </span><span class="s1">getSystemService</span><span class="s2">(</span><span class="s1">NotificationManager</span><span class="s2">.</span><span class="s0">class</span><span class="s2">);</span>
            <span class="s1">notificationManager</span><span class="s2">.</span><span class="s1">createNotificationChannel</span><span class="s2">(</span><span class="s1">channel</span><span class="s2">);</span>
        <span class="s2">}</span>

        <span class="s5">// Create the notification</span>
        <span class="s1">NotificationCompat</span><span class="s2">.</span><span class="s1">Builder notificationBuilder </span><span class="s2">= </span><span class="s0">new </span><span class="s1">NotificationCompat</span><span class="s2">.</span><span class="s1">Builder</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s1">NOTIFICATION_CHANNEL_ID</span><span class="s2">)</span>
                <span class="s2">.</span><span class="s1">setContentTitle</span><span class="s2">(</span><span class="s4">&quot;Geofence Service&quot;</span><span class="s2">)</span>
                <span class="s2">.</span><span class="s1">setContentText</span><span class="s2">(</span><span class="s1">geofenceStatus</span><span class="s2">)</span>
                <span class="s2">.</span><span class="s1">setSmallIcon</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">drawable</span><span class="s2">.</span><span class="s1">user</span><span class="s2">)</span>
                <span class="s2">.</span><span class="s1">setColor</span><span class="s2">(</span><span class="s1">Color</span><span class="s2">.</span><span class="s1">BLUE</span><span class="s2">) </span><span class="s5">// Set the notification color to blue (optional)</span>
                <span class="s2">.</span><span class="s1">setAutoCancel</span><span class="s2">(</span><span class="s0">false</span><span class="s2">);</span>

        <span class="s5">// Set the notification as ongoing, so it cannot be swiped away by the user</span>
        <span class="s1">notificationBuilder</span><span class="s2">.</span><span class="s1">setOngoing</span><span class="s2">(</span><span class="s0">true</span><span class="s2">);</span>

        <span class="s1">Intent notificationIntent </span><span class="s2">= </span><span class="s0">new </span><span class="s1">Intent</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s1">MainActivity</span><span class="s2">.</span><span class="s0">class</span><span class="s2">);</span>
        <span class="s0">int </span><span class="s1">flags</span><span class="s2">;</span>
        <span class="s0">if </span><span class="s2">(</span><span class="s1">Build</span><span class="s2">.</span><span class="s1">VERSION</span><span class="s2">.</span><span class="s1">SDK_INT </span><span class="s2">&lt; </span><span class="s1">Build</span><span class="s2">.</span><span class="s1">VERSION_CODES</span><span class="s2">.</span><span class="s1">S</span><span class="s2">) {</span>
            <span class="s1">flags </span><span class="s2">= </span><span class="s1">PendingIntent</span><span class="s2">.</span><span class="s1">FLAG_UPDATE_CURRENT</span><span class="s2">;</span>
        <span class="s2">} </span><span class="s0">else </span><span class="s2">{</span>
            <span class="s5">// Set the mutability flag for Android S and above</span>
            <span class="s1">flags </span><span class="s2">= </span><span class="s1">PendingIntent</span><span class="s2">.</span><span class="s1">FLAG_UPDATE_CURRENT </span><span class="s2">| </span><span class="s1">PendingIntent</span><span class="s2">.</span><span class="s1">FLAG_IMMUTABLE</span><span class="s2">;</span>
        <span class="s2">}</span>

        <span class="s1">PendingIntent pendingIntent </span><span class="s2">= </span><span class="s1">PendingIntent</span><span class="s2">.</span><span class="s1">getActivity</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s3">0</span><span class="s2">, </span><span class="s1">notificationIntent</span><span class="s2">, </span><span class="s1">flags</span><span class="s2">);</span>
        <span class="s1">notificationBuilder</span><span class="s2">.</span><span class="s1">setContentIntent</span><span class="s2">(</span><span class="s1">pendingIntent</span><span class="s2">);</span>

        <span class="s0">return </span><span class="s1">notificationBuilder</span><span class="s2">.</span><span class="s1">build</span><span class="s2">();</span>
    <span class="s2">}</span>

    <span class="s5">// Call this method to update the geofence status on the notification</span>
    <span class="s0">public void </span><span class="s1">updateGeofenceStatus</span><span class="s2">(</span><span class="s0">boolean </span><span class="s1">insideGeofence</span><span class="s2">) {</span>
        <span class="s1">String geofenceStatus </span><span class="s2">= </span><span class="s1">insideGeofence </span><span class="s2">? </span><span class="s1">GEOFENCE_STATUS_ENTERED </span><span class="s2">: </span><span class="s1">GEOFENCE_STATUS_EXITED</span><span class="s2">;</span>
        <span class="s1">Notification notification </span><span class="s2">= </span><span class="s1">createNotification</span><span class="s2">(</span><span class="s1">geofenceStatus</span><span class="s2">);</span>

        <span class="s1">NotificationManager notificationManager </span><span class="s2">= </span><span class="s1">getSystemService</span><span class="s2">(</span><span class="s1">NotificationManager</span><span class="s2">.</span><span class="s0">class</span><span class="s2">);</span>
        <span class="s1">notificationManager</span><span class="s2">.</span><span class="s1">notify</span><span class="s2">(</span><span class="s1">NOTIFICATION_ID</span><span class="s2">, </span><span class="s1">notification</span><span class="s2">);</span>
    <span class="s2">}</span>
<span class="s2">}</span>
</pre>
</body>
</html>
