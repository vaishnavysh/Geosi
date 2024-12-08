<html>
<head>
<title>Splash_Screen.java</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
.s0 { color: #cf8e6d;}
.s1 { color: #bcbec4;}
.s2 { color: #bcbec4;}
.s3 { color: #2aacb8;}
.s4 { color: #7a7e85;}
</style>
</head>
<body bgcolor="#1e1f22">
<table CELLSPACING=0 CELLPADDING=5 COLS=1 WIDTH="100%" BGCOLOR="#606060" >
<tr><td><center>
<font face="Arial, Helvetica" color="#000000">
Splash_Screen.java</font>
</center></td></tr></table>
<pre><span class="s0">package </span><span class="s1">com</span><span class="s2">.</span><span class="s1">alpha</span><span class="s2">.</span><span class="s1">silentme</span><span class="s2">;</span>



<span class="s0">import </span><span class="s1">androidx</span><span class="s2">.</span><span class="s1">appcompat</span><span class="s2">.</span><span class="s1">app</span><span class="s2">.</span><span class="s1">AppCompatActivity</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">androidx</span><span class="s2">.</span><span class="s1">core</span><span class="s2">.</span><span class="s1">app</span><span class="s2">.</span><span class="s1">ActivityCompat</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">androidx</span><span class="s2">.</span><span class="s1">core</span><span class="s2">.</span><span class="s1">content</span><span class="s2">.</span><span class="s1">ContextCompat</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">Manifest</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">content</span><span class="s2">.</span><span class="s1">Intent</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">content</span><span class="s2">.</span><span class="s1">pm</span><span class="s2">.</span><span class="s1">PackageManager</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">os</span><span class="s2">.</span><span class="s1">Bundle</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">os</span><span class="s2">.</span><span class="s1">Handler</span><span class="s2">;</span>



<span class="s0">public class </span><span class="s1">Splash_Screen </span><span class="s0">extends </span><span class="s1">AppCompatActivity </span><span class="s2">{</span>


    <span class="s0">private static final int </span><span class="s1">SPLASH_DURATION </span><span class="s2">= </span><span class="s3">2000</span><span class="s2">; </span><span class="s4">// 2 seconds</span>
    <span class="s0">private static final int </span><span class="s1">LOCATION_PERMISSION_REQUEST </span><span class="s2">= </span><span class="s3">1</span><span class="s2">;</span>


    <span class="s1">@Override</span>
    <span class="s0">protected void </span><span class="s1">onCreate</span><span class="s2">(</span><span class="s1">Bundle savedInstanceState</span><span class="s2">) {</span>
        <span class="s0">super</span><span class="s2">.</span><span class="s1">onCreate</span><span class="s2">(</span><span class="s1">savedInstanceState</span><span class="s2">);</span>
        <span class="s1">setContentView</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">layout</span><span class="s2">.</span><span class="s1">activity_splash_screen</span><span class="s2">);</span>

        <span class="s4">// Check and request location permission</span>
        <span class="s0">if </span><span class="s2">(</span><span class="s1">checkAndRequestLocationPermission</span><span class="s2">()) {</span>
            <span class="s1">proceedToNextActivity</span><span class="s2">();</span>
        <span class="s2">}</span>
    <span class="s2">}</span>

    <span class="s0">private boolean </span><span class="s1">checkAndRequestLocationPermission</span><span class="s2">() {</span>
        <span class="s0">if </span><span class="s2">(</span><span class="s1">ContextCompat</span><span class="s2">.</span><span class="s1">checkSelfPermission</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s1">Manifest</span><span class="s2">.</span><span class="s1">permission</span><span class="s2">.</span><span class="s1">ACCESS_FINE_LOCATION</span><span class="s2">) != </span><span class="s1">PackageManager</span><span class="s2">.</span><span class="s1">PERMISSION_GRANTED</span><span class="s2">) {</span>
            <span class="s1">ActivityCompat</span><span class="s2">.</span><span class="s1">requestPermissions</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s0">new </span><span class="s1">String</span><span class="s2">[]{</span><span class="s1">Manifest</span><span class="s2">.</span><span class="s1">permission</span><span class="s2">.</span><span class="s1">ACCESS_FINE_LOCATION</span><span class="s2">}, </span><span class="s1">LOCATION_PERMISSION_REQUEST</span><span class="s2">);</span>
            <span class="s0">return false</span><span class="s2">;</span>
        <span class="s2">} </span><span class="s0">else </span><span class="s2">{</span>
            <span class="s0">return true</span><span class="s2">;</span>
        <span class="s2">}</span>
    <span class="s2">}</span>

    <span class="s1">@Override</span>
    <span class="s0">public void </span><span class="s1">onRequestPermissionsResult</span><span class="s2">(</span><span class="s0">int </span><span class="s1">requestCode</span><span class="s2">, </span><span class="s1">String</span><span class="s2">[] </span><span class="s1">permissions</span><span class="s2">, </span><span class="s0">int</span><span class="s2">[] </span><span class="s1">grantResults</span><span class="s2">) {</span>
        <span class="s0">super</span><span class="s2">.</span><span class="s1">onRequestPermissionsResult</span><span class="s2">(</span><span class="s1">requestCode</span><span class="s2">, </span><span class="s1">permissions</span><span class="s2">, </span><span class="s1">grantResults</span><span class="s2">);</span>
        <span class="s0">if </span><span class="s2">(</span><span class="s1">requestCode </span><span class="s2">== </span><span class="s1">LOCATION_PERMISSION_REQUEST</span><span class="s2">) {</span>
            <span class="s0">if </span><span class="s2">(</span><span class="s1">grantResults</span><span class="s2">.</span><span class="s1">length </span><span class="s2">&gt; </span><span class="s3">0 </span><span class="s2">&amp;&amp; </span><span class="s1">grantResults</span><span class="s2">[</span><span class="s3">0</span><span class="s2">] == </span><span class="s1">PackageManager</span><span class="s2">.</span><span class="s1">PERMISSION_GRANTED</span><span class="s2">) {</span>
                <span class="s1">proceedToNextActivity</span><span class="s2">();</span>
            <span class="s2">}</span>
        <span class="s2">}</span>
    <span class="s2">}</span>

    <span class="s0">private void </span><span class="s1">proceedToNextActivity</span><span class="s2">() {</span>
        <span class="s4">// Handler to delay the intent to another activity</span>
        <span class="s0">new </span><span class="s1">Handler</span><span class="s2">().</span><span class="s1">postDelayed</span><span class="s2">(</span><span class="s0">new </span><span class="s1">Runnable</span><span class="s2">() {</span>
            <span class="s1">@Override</span>
            <span class="s0">public void </span><span class="s1">run</span><span class="s2">() {</span>
                <span class="s4">// Create an intent to start the target activity</span>
                <span class="s1">Intent intent </span><span class="s2">= </span><span class="s0">new </span><span class="s1">Intent</span><span class="s2">(</span><span class="s1">Splash_Screen</span><span class="s2">.</span><span class="s0">this</span><span class="s2">, </span><span class="s1">LoginActivity</span><span class="s2">.</span><span class="s0">class</span><span class="s2">);</span>
                <span class="s1">startActivity</span><span class="s2">(</span><span class="s1">intent</span><span class="s2">);</span>

                <span class="s4">// Finish this activity, so the user cannot go back to the splash screen</span>
                <span class="s1">finish</span><span class="s2">();</span>
            <span class="s2">}</span>
        <span class="s2">}, </span><span class="s1">SPLASH_DURATION</span><span class="s2">);</span>
    <span class="s2">}</span>
<span class="s2">}</span>














       <span class="s4">/* // Handler to delay the intent to another activity 
        new Handler().postDelayed(new Runnable() { 
            @Override 
            public void run() { 
                // Create an intent to start the target activity 
                Intent intent = new Intent(Splash_Screen.this, LoginActivity.class); 
                startActivity(intent); 
 
                // Finish this activity, so the user cannot go back to the splash screen 
                finish(); 
            } 
        }, SPLASH_DURATION); 
    } 
} 
*/</span></pre>
</body>
</html>
