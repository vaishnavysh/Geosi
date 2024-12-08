<html>
<head>
<title>GeofenceBroadcastReceiver.java</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
.s0 { color: #cf8e6d;}
.s1 { color: #bcbec4;}
.s2 { color: #bcbec4;}
.s3 { color: #6aab73;}
.s4 { color: #2aacb8;}
.s5 { color: #7a7e85;}
</style>
</head>
<body bgcolor="#1e1f22">
<table CELLSPACING=0 CELLPADDING=5 COLS=1 WIDTH="100%" BGCOLOR="#606060" >
<tr><td><center>
<font face="Arial, Helvetica" color="#000000">
GeofenceBroadcastReceiver.java</font>
</center></td></tr></table>
<pre><span class="s0">package </span><span class="s1">com</span><span class="s2">.</span><span class="s1">alpha</span><span class="s2">.</span><span class="s1">silentme</span><span class="s2">;</span>
<span class="s0">import static </span><span class="s1">android</span><span class="s2">.</span><span class="s1">media</span><span class="s2">.</span><span class="s1">AudioManager</span><span class="s2">.</span><span class="s1">RINGER_MODE_NORMAL</span><span class="s2">;</span>
<span class="s0">import static </span><span class="s1">android</span><span class="s2">.</span><span class="s1">media</span><span class="s2">.</span><span class="s1">AudioManager</span><span class="s2">.</span><span class="s1">RINGER_MODE_VIBRATE</span><span class="s2">;</span>

<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">content</span><span class="s2">.</span><span class="s1">BroadcastReceiver</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">content</span><span class="s2">.</span><span class="s1">Context</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">content</span><span class="s2">.</span><span class="s1">Intent</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">media</span><span class="s2">.</span><span class="s1">AudioManager</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">os</span><span class="s2">.</span><span class="s1">Build</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">util</span><span class="s2">.</span><span class="s1">Log</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">widget</span><span class="s2">.</span><span class="s1">Toast</span><span class="s2">;</span>

<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">android</span><span class="s2">.</span><span class="s1">gms</span><span class="s2">.</span><span class="s1">location</span><span class="s2">.</span><span class="s1">Geofence</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">android</span><span class="s2">.</span><span class="s1">gms</span><span class="s2">.</span><span class="s1">location</span><span class="s2">.</span><span class="s1">GeofencingEvent</span><span class="s2">;</span>
<span class="s0">public class </span><span class="s1">GeofenceBroadcastReceiver </span><span class="s0">extends </span><span class="s1">BroadcastReceiver </span><span class="s2">{</span>
    <span class="s1">@Override</span>
    <span class="s0">public void </span><span class="s1">onReceive</span><span class="s2">(</span><span class="s1">Context context</span><span class="s2">, </span><span class="s1">Intent intent</span><span class="s2">) {</span>
        <span class="s0">if </span><span class="s2">(</span><span class="s1">intent </span><span class="s2">!= </span><span class="s0">null </span><span class="s2">&amp;&amp; </span><span class="s1">intent</span><span class="s2">.</span><span class="s1">getAction</span><span class="s2">() != </span><span class="s0">null</span><span class="s2">) {</span>
            <span class="s0">if </span><span class="s2">(</span><span class="s1">intent</span><span class="s2">.</span><span class="s1">getAction</span><span class="s2">().</span><span class="s1">equals</span><span class="s2">(</span><span class="s3">&quot;com.alpha.silentme.ACTION_RECEIVE_GEOFENCE&quot;</span><span class="s2">)) {</span>
                <span class="s0">int </span><span class="s1">geofenceTransition </span><span class="s2">= </span><span class="s1">intent</span><span class="s2">.</span><span class="s1">getIntExtra</span><span class="s2">(</span><span class="s3">&quot;geofenceTransition&quot;</span><span class="s2">, -</span><span class="s4">1</span><span class="s2">);</span>
                <span class="s0">if </span><span class="s2">(</span><span class="s1">geofenceTransition </span><span class="s2">== </span><span class="s1">Geofence</span><span class="s2">.</span><span class="s1">GEOFENCE_TRANSITION_ENTER</span><span class="s2">) {</span>
                    <span class="s5">// Device entered the geofence radius</span>
                    <span class="s1">setRingerMode</span><span class="s2">(</span><span class="s1">context</span><span class="s2">, </span><span class="s1">RINGER_MODE_VIBRATE</span><span class="s2">);</span>
                <span class="s2">} </span><span class="s0">else if </span><span class="s2">(</span><span class="s1">geofenceTransition </span><span class="s2">== </span><span class="s1">Geofence</span><span class="s2">.</span><span class="s1">GEOFENCE_TRANSITION_EXIT</span><span class="s2">) {</span>
                    <span class="s5">// Device exited the geofence radius</span>
                    <span class="s1">setRingerMode</span><span class="s2">(</span><span class="s1">context</span><span class="s2">, </span><span class="s1">RINGER_MODE_NORMAL</span><span class="s2">);</span>
                <span class="s2">}</span>
            <span class="s2">}</span>
        <span class="s2">}</span>
    <span class="s2">}</span>

    <span class="s0">private void </span><span class="s1">setRingerMode</span><span class="s2">(</span><span class="s1">Context context</span><span class="s2">, </span><span class="s0">int </span><span class="s1">ringerMode</span><span class="s2">) {</span>
        <span class="s1">AudioManager audioManager </span><span class="s2">= (</span><span class="s1">AudioManager</span><span class="s2">) </span><span class="s1">context</span><span class="s2">.</span><span class="s1">getSystemService</span><span class="s2">(</span><span class="s1">Context</span><span class="s2">.</span><span class="s1">AUDIO_SERVICE</span><span class="s2">);</span>
        <span class="s0">if </span><span class="s2">(</span><span class="s1">audioManager </span><span class="s2">!= </span><span class="s0">null</span><span class="s2">) {</span>
            <span class="s1">audioManager</span><span class="s2">.</span><span class="s1">setRingerMode</span><span class="s2">(</span><span class="s1">ringerMode</span><span class="s2">);</span>
        <span class="s2">}</span>
    <span class="s2">}</span>
<span class="s2">}</span>
</pre>
</body>
</html>
