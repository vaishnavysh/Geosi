<html>
<head>
<title>GeofenceBackgroundService.java</title>
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
GeofenceBackgroundService.java</font>
</center></td></tr></table>
<pre><span class="s0">package </span><span class="s1">com</span><span class="s2">.</span><span class="s1">alpha</span><span class="s2">.</span><span class="s1">silentme</span><span class="s2">;</span>

<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">app</span><span class="s2">.</span><span class="s1">IntentService</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">content</span><span class="s2">.</span><span class="s1">Context</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">content</span><span class="s2">.</span><span class="s1">Intent</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">media</span><span class="s2">.</span><span class="s1">AudioManager</span><span class="s2">;</span>

<span class="s0">public class </span><span class="s1">GeofenceBackgroundService </span><span class="s0">extends </span><span class="s1">IntentService </span><span class="s2">{</span>

    <span class="s0">public </span><span class="s1">GeofenceBackgroundService</span><span class="s2">() {</span>
        <span class="s0">super</span><span class="s2">(</span><span class="s3">&quot;GeofenceBackgroundService&quot;</span><span class="s2">);</span>
    <span class="s2">}</span>

    <span class="s1">@Override</span>
    <span class="s0">protected void </span><span class="s1">onHandleIntent</span><span class="s2">(</span><span class="s1">Intent intent</span><span class="s2">) {</span>
        <span class="s1">GeofenceBroadcastReceiver receiver </span><span class="s2">= </span><span class="s0">new </span><span class="s1">GeofenceBroadcastReceiver</span><span class="s2">();</span>
        <span class="s1">receiver</span><span class="s2">.</span><span class="s1">onReceive</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s1">intent</span><span class="s2">);</span>
    <span class="s2">}</span>

    <span class="s0">private void </span><span class="s1">setVolumeToLowest</span><span class="s2">(</span><span class="s1">Context context</span><span class="s2">) {</span>
        <span class="s1">AudioManager audioManager </span><span class="s2">= (</span><span class="s1">AudioManager</span><span class="s2">) </span><span class="s1">context</span><span class="s2">.</span><span class="s1">getSystemService</span><span class="s2">(</span><span class="s1">Context</span><span class="s2">.</span><span class="s1">AUDIO_SERVICE</span><span class="s2">);</span>
        <span class="s0">if </span><span class="s2">(</span><span class="s1">audioManager </span><span class="s2">!= </span><span class="s0">null</span><span class="s2">) {</span>
            <span class="s0">int </span><span class="s1">lowestVolume </span><span class="s2">= </span><span class="s4">0</span><span class="s2">;</span>
            <span class="s0">if </span><span class="s2">(</span><span class="s1">android</span><span class="s2">.</span><span class="s1">os</span><span class="s2">.</span><span class="s1">Build</span><span class="s2">.</span><span class="s1">VERSION</span><span class="s2">.</span><span class="s1">SDK_INT </span><span class="s2">&gt;= </span><span class="s1">android</span><span class="s2">.</span><span class="s1">os</span><span class="s2">.</span><span class="s1">Build</span><span class="s2">.</span><span class="s1">VERSION_CODES</span><span class="s2">.</span><span class="s1">P</span><span class="s2">) {</span>
                <span class="s1">lowestVolume </span><span class="s2">= </span><span class="s1">audioManager</span><span class="s2">.</span><span class="s1">getStreamMinVolume</span><span class="s2">(</span><span class="s1">AudioManager</span><span class="s2">.</span><span class="s1">STREAM_RING</span><span class="s2">);</span>
            <span class="s2">}</span>
            <span class="s1">audioManager</span><span class="s2">.</span><span class="s1">setStreamVolume</span><span class="s2">(</span><span class="s1">AudioManager</span><span class="s2">.</span><span class="s1">STREAM_RING</span><span class="s2">, </span><span class="s1">lowestVolume</span><span class="s2">, </span><span class="s4">0</span><span class="s2">);</span>

            <span class="s5">// Set the device to vibrate mode</span>
            <span class="s1">audioManager</span><span class="s2">.</span><span class="s1">setRingerMode</span><span class="s2">(</span><span class="s1">AudioManager</span><span class="s2">.</span><span class="s1">RINGER_MODE_VIBRATE</span><span class="s2">);</span>
        <span class="s2">}</span>
    <span class="s2">}</span>
<span class="s2">}</span>
</pre>
</body>
</html>
