<html>
<head>
<title>LoginActivity.java</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
.s0 { color: #cf8e6d;}
.s1 { color: #bcbec4;}
.s2 { color: #bcbec4;}
.s3 { color: #7a7e85;}
.s4 { color: #6aab73;}
.s5 { color: #2aacb8;}
</style>
</head>
<body bgcolor="#1e1f22">
<table CELLSPACING=0 CELLPADDING=5 COLS=1 WIDTH="100%" BGCOLOR="#606060" >
<tr><td><center>
<font face="Arial, Helvetica" color="#000000">
LoginActivity.java</font>
</center></td></tr></table>
<pre><span class="s0">package </span><span class="s1">com</span><span class="s2">.</span><span class="s1">alpha</span><span class="s2">.</span><span class="s1">silentme</span><span class="s2">;</span>

<span class="s0">import </span><span class="s1">androidx</span><span class="s2">.</span><span class="s1">annotation</span><span class="s2">.</span><span class="s1">RequiresApi</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">androidx</span><span class="s2">.</span><span class="s1">appcompat</span><span class="s2">.</span><span class="s1">app</span><span class="s2">.</span><span class="s1">AppCompatActivity</span><span class="s2">;</span>

<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">animation</span><span class="s2">.</span><span class="s1">Animator</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">content</span><span class="s2">.</span><span class="s1">Intent</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">net</span><span class="s2">.</span><span class="s1">Uri</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">os</span><span class="s2">.</span><span class="s1">Build</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">content</span><span class="s2">.</span><span class="s1">SharedPreferences</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">os</span><span class="s2">.</span><span class="s1">Bundle</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">os</span><span class="s2">.</span><span class="s1">Handler</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">os</span><span class="s2">.</span><span class="s1">Looper</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">provider</span><span class="s2">.</span><span class="s1">MediaStore</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">util</span><span class="s2">.</span><span class="s1">Log</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">view</span><span class="s2">.</span><span class="s1">View</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">view</span><span class="s2">.</span><span class="s1">ViewAnimationUtils</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">view</span><span class="s2">.</span><span class="s1">animation</span><span class="s2">.</span><span class="s1">DecelerateInterpolator</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">widget</span><span class="s2">.</span><span class="s1">AdapterView</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">widget</span><span class="s2">.</span><span class="s1">ArrayAdapter</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">widget</span><span class="s2">.</span><span class="s1">Button</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">widget</span><span class="s2">.</span><span class="s1">EditText</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">widget</span><span class="s2">.</span><span class="s1">ImageView</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">widget</span><span class="s2">.</span><span class="s1">LinearLayout</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">widget</span><span class="s2">.</span><span class="s1">Spinner</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">widget</span><span class="s2">.</span><span class="s1">Toast</span><span class="s2">;</span>

<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">alpha</span><span class="s2">.</span><span class="s1">silentme</span><span class="s2">.</span><span class="s1">bean</span><span class="s2">.</span><span class="s1">User</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">android</span><span class="s2">.</span><span class="s1">gms</span><span class="s2">.</span><span class="s1">maps</span><span class="s2">.</span><span class="s1">model</span><span class="s2">.</span><span class="s1">Dash</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">android</span><span class="s2">.</span><span class="s1">material</span><span class="s2">.</span><span class="s1">floatingactionbutton</span><span class="s2">.</span><span class="s1">FloatingActionButton</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">firebase</span><span class="s2">.</span><span class="s1">auth</span><span class="s2">.</span><span class="s1">FirebaseAuth</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">firebase</span><span class="s2">.</span><span class="s1">database</span><span class="s2">.</span><span class="s1">DatabaseReference</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">firebase</span><span class="s2">.</span><span class="s1">database</span><span class="s2">.</span><span class="s1">FirebaseDatabase</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">firebase</span><span class="s2">.</span><span class="s1">storage</span><span class="s2">.</span><span class="s1">FirebaseStorage</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">firebase</span><span class="s2">.</span><span class="s1">storage</span><span class="s2">.</span><span class="s1">StorageReference</span><span class="s2">;</span>

<span class="s0">public class </span><span class="s1">LoginActivity </span><span class="s0">extends </span><span class="s1">AppCompatActivity </span><span class="s2">{</span>
    <span class="s1">EditText edtEmail</span><span class="s2">,</span><span class="s1">edtPassword</span><span class="s2">;</span>
    <span class="s0">private </span><span class="s1">FirebaseAuth firebaseAuth</span><span class="s2">;</span>
    <span class="s1">Button btnLogin</span><span class="s2">;</span>
    <span class="s0">private </span><span class="s1">FloatingActionButton fab</span><span class="s2">;</span>
    <span class="s0">private </span><span class="s1">LinearLayout login_page_login_page</span><span class="s2">,</span><span class="s1">login_page_register_page</span><span class="s2">;</span>
    <span class="s1">SharedPreferences sharedPreferences</span><span class="s2">;</span>

    <span class="s3">//Signup Variables</span>
    <span class="s0">private final </span><span class="s1">String</span><span class="s2">[] </span><span class="s1">spinnerValues </span><span class="s2">= {</span><span class="s4">&quot;vidya academy of science and technology&quot;</span><span class="s2">};</span>

    <span class="s1">String valCollege</span><span class="s2">=</span><span class="s4">&quot;&quot;</span><span class="s2">;</span>
    <span class="s1">Spinner spinner</span><span class="s2">;</span>
    <span class="s1">EditText edtEmailSignup</span><span class="s2">,</span><span class="s1">edtName</span><span class="s2">,</span><span class="s1">edtPasswordSignup</span><span class="s2">,</span><span class="s1">edtConfirmPasswordSignup</span><span class="s2">;</span>
    <span class="s1">Button btnSignup</span><span class="s2">;</span>
    <span class="s0">private </span><span class="s1">DatabaseReference usersReference</span><span class="s2">;</span>
    <span class="s0">private </span><span class="s1">ImageView imgProfilePicture</span><span class="s2">;</span>
    <span class="s0">private </span><span class="s1">Uri selectedImageUri</span><span class="s2">; </span><span class="s3">// Store the selected image URI</span>

    <span class="s0">private static final int </span><span class="s1">PICK_IMAGE_REQUEST </span><span class="s2">= </span><span class="s5">1</span><span class="s2">;</span>
    <span class="s0">private </span><span class="s1">String profilePictureUrl</span><span class="s2">=</span><span class="s4">&quot;&quot;</span><span class="s2">;</span>

    <span class="s1">@Override</span>
    <span class="s0">protected void </span><span class="s1">onCreate</span><span class="s2">(</span><span class="s1">Bundle savedInstanceState</span><span class="s2">) {</span>
        <span class="s0">super</span><span class="s2">.</span><span class="s1">onCreate</span><span class="s2">(</span><span class="s1">savedInstanceState</span><span class="s2">);</span>
        <span class="s1">setContentView</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">layout</span><span class="s2">.</span><span class="s1">activity_login</span><span class="s2">);</span>

        <span class="s1">initVars</span><span class="s2">();</span>
        <span class="s1">initVarsSignup</span><span class="s2">();</span>
    <span class="s2">}</span>

    <span class="s0">private void </span><span class="s1">initVarsSignup</span><span class="s2">() {</span>

        <span class="s1">spinner </span><span class="s2">= </span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">spinnerColleges</span><span class="s2">);</span>
        <span class="s1">edtEmailSignup </span><span class="s2">= </span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">edtEmailSignup</span><span class="s2">);</span>
        <span class="s1">edtName </span><span class="s2">= </span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">edtNameSignup</span><span class="s2">);</span>
        <span class="s1">edtPasswordSignup </span><span class="s2">= </span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">edtPasswordSignup</span><span class="s2">);</span>
        <span class="s1">edtConfirmPasswordSignup </span><span class="s2">= </span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">edtConfirmPassword</span><span class="s2">);</span>
        <span class="s1">btnSignup </span><span class="s2">= </span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">btnRegister</span><span class="s2">);</span>
        <span class="s1">imgProfilePicture </span><span class="s2">= </span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">imgProfilePicture</span><span class="s2">);</span>
        <span class="s1">Button btnChoosePicture </span><span class="s2">= </span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">btnChoosePicture1</span><span class="s2">);</span>

        <span class="s1">sharedPreferences </span><span class="s2">= </span><span class="s1">getSharedPreferences</span><span class="s2">(</span><span class="s4">&quot;session&quot;</span><span class="s2">, </span><span class="s1">MODE_PRIVATE</span><span class="s2">);</span>

        <span class="s1">btnChoosePicture</span><span class="s2">.</span><span class="s1">setOnClickListener</span><span class="s2">(</span><span class="s1">v -&gt; </span><span class="s2">{</span>
            <span class="s1">Intent intent </span><span class="s2">= </span><span class="s0">new </span><span class="s1">Intent</span><span class="s2">(</span><span class="s1">Intent</span><span class="s2">.</span><span class="s1">ACTION_PICK</span><span class="s2">, </span><span class="s1">MediaStore</span><span class="s2">.</span><span class="s1">Images</span><span class="s2">.</span><span class="s1">Media</span><span class="s2">.</span><span class="s1">EXTERNAL_CONTENT_URI</span><span class="s2">);</span>
            <span class="s1">startActivityForResult</span><span class="s2">(</span><span class="s1">intent</span><span class="s2">, </span><span class="s1">PICK_IMAGE_REQUEST</span><span class="s2">);</span>
        <span class="s2">});</span>


        <span class="s1">firebaseAuth </span><span class="s2">= </span><span class="s1">FirebaseAuth</span><span class="s2">.</span><span class="s1">getInstance</span><span class="s2">();</span>
        <span class="s1">usersReference </span><span class="s2">= </span><span class="s1">FirebaseDatabase</span><span class="s2">.</span><span class="s1">getInstance</span><span class="s2">().</span><span class="s1">getReference</span><span class="s2">().</span><span class="s1">child</span><span class="s2">(</span><span class="s4">&quot;users&quot;</span><span class="s2">);</span>


        <span class="s1">btnSignup</span><span class="s2">.</span><span class="s1">setOnClickListener</span><span class="s2">(</span><span class="s0">new </span><span class="s1">View</span><span class="s2">.</span><span class="s1">OnClickListener</span><span class="s2">() {</span>
            <span class="s1">@Override</span>
            <span class="s0">public void </span><span class="s1">onClick</span><span class="s2">(</span><span class="s1">View view</span><span class="s2">) {</span>
                <span class="s0">if </span><span class="s2">(</span><span class="s1">validationsSignup</span><span class="s2">())</span>
                <span class="s2">{</span>
                    <span class="s3">//Firebase Signup User\</span>
                    <span class="s1">signupUser</span><span class="s2">();</span>
                <span class="s2">}</span>
            <span class="s2">}</span>
        <span class="s2">});</span>

        <span class="s1">ArrayAdapter</span><span class="s2">&lt;</span><span class="s1">String</span><span class="s2">&gt; </span><span class="s1">adapter </span><span class="s2">= </span><span class="s0">new </span><span class="s1">ArrayAdapter</span><span class="s2">&lt;</span><span class="s1">String</span><span class="s2">&gt;(</span>
                <span class="s0">this</span><span class="s2">,</span>
                <span class="s1">R</span><span class="s2">.</span><span class="s1">layout</span><span class="s2">.</span><span class="s1">spinner_item</span><span class="s2">, </span><span class="s3">// Custom item layout</span>
                <span class="s1">spinnerValues</span>
        <span class="s2">);</span>

        <span class="s1">adapter</span><span class="s2">.</span><span class="s1">setDropDownViewResource</span><span class="s2">(</span><span class="s1">android</span><span class="s2">.</span><span class="s1">R</span><span class="s2">.</span><span class="s1">layout</span><span class="s2">.</span><span class="s1">simple_spinner_dropdown_item</span><span class="s2">);</span>
        <span class="s1">spinner</span><span class="s2">.</span><span class="s1">setAdapter</span><span class="s2">(</span><span class="s1">adapter</span><span class="s2">);</span>

        <span class="s1">spinner</span><span class="s2">.</span><span class="s1">setOnItemSelectedListener</span><span class="s2">(</span><span class="s0">new </span><span class="s1">AdapterView</span><span class="s2">.</span><span class="s1">OnItemSelectedListener</span><span class="s2">() {</span>
            <span class="s1">@Override</span>
            <span class="s0">public void </span><span class="s1">onItemSelected</span><span class="s2">(</span><span class="s1">AdapterView</span><span class="s2">&lt;?&gt; </span><span class="s1">parentView</span><span class="s2">, </span><span class="s1">View selectedItemView</span><span class="s2">, </span><span class="s0">int </span><span class="s1">position</span><span class="s2">, </span><span class="s0">long </span><span class="s1">id</span><span class="s2">) {</span>
                <span class="s1">String selectedValue </span><span class="s2">= </span><span class="s1">spinnerValues</span><span class="s2">[</span><span class="s1">position</span><span class="s2">];</span>
                <span class="s1">valCollege </span><span class="s2">= </span><span class="s1">selectedValue</span><span class="s2">;</span>
               <span class="s3">// Toast.makeText(LoginActivity.this, &quot;Selected: &quot; + selectedValue, Toast.LENGTH_SHORT).show();</span>
            <span class="s2">}</span>

            <span class="s1">@Override</span>
            <span class="s0">public void </span><span class="s1">onNothingSelected</span><span class="s2">(</span><span class="s1">AdapterView</span><span class="s2">&lt;?&gt; </span><span class="s1">parentView</span><span class="s2">) {</span>
                <span class="s3">// Do nothing here</span>
            <span class="s2">}</span>
        <span class="s2">});</span>
    <span class="s2">}</span>

    <span class="s0">private boolean </span><span class="s1">validationsSignup</span><span class="s2">() {</span>
        <span class="s0">if </span><span class="s2">(</span><span class="s1">profilePictureUrl</span><span class="s2">.</span><span class="s1">isEmpty</span><span class="s2">())</span>
        <span class="s2">{</span>
            <span class="s1">Toast</span><span class="s2">.</span><span class="s1">makeText</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s4">&quot;Please Select Image&quot;</span><span class="s2">, </span><span class="s1">Toast</span><span class="s2">.</span><span class="s1">LENGTH_SHORT</span><span class="s2">).</span><span class="s1">show</span><span class="s2">();</span>
            <span class="s0">return false</span><span class="s2">;</span>
        <span class="s2">}</span>
        <span class="s0">else if </span><span class="s2">(</span><span class="s1">edtName</span><span class="s2">.</span><span class="s1">getText</span><span class="s2">().</span><span class="s1">toString</span><span class="s2">().</span><span class="s1">isEmpty</span><span class="s2">())</span>
        <span class="s2">{</span>
            <span class="s1">Toast</span><span class="s2">.</span><span class="s1">makeText</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s4">&quot;Please enter Name&quot;</span><span class="s2">, </span><span class="s1">Toast</span><span class="s2">.</span><span class="s1">LENGTH_SHORT</span><span class="s2">).</span><span class="s1">show</span><span class="s2">();</span>
            <span class="s0">return false</span><span class="s2">;</span>
        <span class="s2">}</span>
       <span class="s0">else if </span><span class="s2">(</span><span class="s1">edtEmailSignup</span><span class="s2">.</span><span class="s1">getText</span><span class="s2">().</span><span class="s1">toString</span><span class="s2">().</span><span class="s1">trim</span><span class="s2">().</span><span class="s1">isEmpty</span><span class="s2">()) {</span>
        <span class="s1">Toast</span><span class="s2">.</span><span class="s1">makeText</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s4">&quot;Please enter email&quot;</span><span class="s2">, </span><span class="s1">Toast</span><span class="s2">.</span><span class="s1">LENGTH_SHORT</span><span class="s2">).</span><span class="s1">show</span><span class="s2">();</span>
        <span class="s0">return false</span><span class="s2">;</span>
       <span class="s2">}</span>

        <span class="s0">else if </span><span class="s2">(</span><span class="s1">edtPasswordSignup</span><span class="s2">.</span><span class="s1">getText</span><span class="s2">().</span><span class="s1">toString</span><span class="s2">().</span><span class="s1">isEmpty</span><span class="s2">())</span>
        <span class="s2">{</span>
            <span class="s1">Toast</span><span class="s2">.</span><span class="s1">makeText</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s4">&quot;Please enter Password&quot;</span><span class="s2">, </span><span class="s1">Toast</span><span class="s2">.</span><span class="s1">LENGTH_SHORT</span><span class="s2">).</span><span class="s1">show</span><span class="s2">();</span>
            <span class="s0">return false</span><span class="s2">;</span>
        <span class="s2">}</span>
        <span class="s0">else if </span><span class="s2">(!(</span><span class="s1">edtPasswordSignup</span><span class="s2">.</span><span class="s1">getText</span><span class="s2">().</span><span class="s1">toString</span><span class="s2">().</span><span class="s1">equals</span><span class="s2">(</span><span class="s1">edtConfirmPasswordSignup</span><span class="s2">.</span><span class="s1">getText</span><span class="s2">().</span><span class="s1">toString</span><span class="s2">())))</span>
        <span class="s2">{</span>
            <span class="s1">Toast</span><span class="s2">.</span><span class="s1">makeText</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s4">&quot;Password mismatch&quot;</span><span class="s2">, </span><span class="s1">Toast</span><span class="s2">.</span><span class="s1">LENGTH_SHORT</span><span class="s2">).</span><span class="s1">show</span><span class="s2">();</span>
            <span class="s0">return false</span><span class="s2">;</span>
        <span class="s2">}</span>
        <span class="s0">else </span><span class="s2">{</span>
            <span class="s0">return true</span><span class="s2">;</span>
        <span class="s2">}</span>

    <span class="s2">}</span>

    <span class="s0">private void </span><span class="s1">signupUser</span><span class="s2">() {</span>
        <span class="s0">final </span><span class="s1">String email </span><span class="s2">= </span><span class="s1">edtEmailSignup</span><span class="s2">.</span><span class="s1">getText</span><span class="s2">().</span><span class="s1">toString</span><span class="s2">().</span><span class="s1">trim</span><span class="s2">();</span>
        <span class="s1">Log</span><span class="s2">.</span><span class="s1">d</span><span class="s2">(</span><span class="s4">&quot;Debug&quot;</span><span class="s2">, </span><span class="s4">&quot;Email: &quot; </span><span class="s2">+ </span><span class="s1">email</span><span class="s2">);</span>
        <span class="s0">final </span><span class="s1">String password </span><span class="s2">= </span><span class="s1">edtPasswordSignup</span><span class="s2">.</span><span class="s1">getText</span><span class="s2">().</span><span class="s1">toString</span><span class="s2">();</span>
        <span class="s0">final </span><span class="s1">String name </span><span class="s2">= </span><span class="s1">edtName</span><span class="s2">.</span><span class="s1">getText</span><span class="s2">().</span><span class="s1">toString</span><span class="s2">();</span>
        <span class="s0">final </span><span class="s1">String college </span><span class="s2">= </span><span class="s1">valCollege</span><span class="s2">;</span>
        <span class="s0">long </span><span class="s1">currentTimeMillis </span><span class="s2">= </span><span class="s1">System</span><span class="s2">.</span><span class="s1">currentTimeMillis</span><span class="s2">();</span>


        <span class="s1">firebaseAuth</span><span class="s2">.</span><span class="s1">createUserWithEmailAndPassword</span><span class="s2">(</span><span class="s1">email</span><span class="s2">, </span><span class="s1">password</span><span class="s2">)</span>
                <span class="s2">.</span><span class="s1">addOnCompleteListener</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s1">task -&gt; </span><span class="s2">{</span>
                    <span class="s0">if </span><span class="s2">(</span><span class="s1">task</span><span class="s2">.</span><span class="s1">isSuccessful</span><span class="s2">()) {</span>
                        <span class="s1">String userId </span><span class="s2">= </span><span class="s1">firebaseAuth</span><span class="s2">.</span><span class="s1">getCurrentUser</span><span class="s2">().</span><span class="s1">getUid</span><span class="s2">();</span>

                        <span class="s3">// Upload the selected image to Firebase Storage</span>
                        <span class="s1">StorageReference storageRef </span><span class="s2">= </span><span class="s1">FirebaseStorage</span><span class="s2">.</span><span class="s1">getInstance</span><span class="s2">().</span><span class="s1">getReference</span><span class="s2">();</span>
                        <span class="s1">StorageReference profilePictureRef </span><span class="s2">= </span><span class="s1">storageRef</span><span class="s2">.</span><span class="s1">child</span><span class="s2">(</span><span class="s4">&quot;profile_pictures/&quot; </span><span class="s2">+ </span><span class="s1">userId</span><span class="s2">);</span>
                        <span class="s1">profilePictureRef</span><span class="s2">.</span><span class="s1">putFile</span><span class="s2">(</span><span class="s1">selectedImageUri</span><span class="s2">)</span>
                                <span class="s2">.</span><span class="s1">addOnSuccessListener</span><span class="s2">(</span><span class="s1">taskSnapshot -&gt; </span><span class="s2">{</span>
                                    <span class="s1">profilePictureRef</span><span class="s2">.</span><span class="s1">getDownloadUrl</span><span class="s2">().</span><span class="s1">addOnSuccessListener</span><span class="s2">(</span><span class="s1">uri -&gt; </span><span class="s2">{</span>
                                        <span class="s1">String profilePicUrl </span><span class="s2">= </span><span class="s1">uri</span><span class="s2">.</span><span class="s1">toString</span><span class="s2">(); </span><span class="s3">// Set the profile picture URL</span>

                                        <span class="s3">// Create a new user object with all the data including profilePictureUrl</span>
                                        <span class="s1">User user </span><span class="s2">= </span><span class="s0">new </span><span class="s1">User</span><span class="s2">(</span><span class="s1">email</span><span class="s2">,</span><span class="s1">name</span><span class="s2">, </span><span class="s1">college</span><span class="s2">, </span><span class="s1">profilePicUrl</span><span class="s2">,</span><span class="s1">currentTimeMillis</span><span class="s2">);</span>

                                        <span class="s3">// Save the user object to the Realtime Database</span>
                                        <span class="s1">DatabaseReference currentUserReference </span><span class="s2">= </span><span class="s1">usersReference</span><span class="s2">.</span><span class="s1">child</span><span class="s2">(</span><span class="s1">userId</span><span class="s2">);</span>
                                        <span class="s1">currentUserReference</span><span class="s2">.</span><span class="s1">setValue</span><span class="s2">(</span><span class="s1">user</span><span class="s2">);</span>
                                        <span class="s1">SharedPreferences</span><span class="s2">.</span><span class="s1">Editor editor</span><span class="s2">=</span><span class="s1">sharedPreferences</span><span class="s2">.</span><span class="s1">edit</span><span class="s2">();</span>
                                        <span class="s1">editor</span><span class="s2">.</span><span class="s1">putString</span><span class="s2">(</span><span class="s4">&quot;email&quot;</span><span class="s2">,</span><span class="s1">email</span><span class="s2">);</span>
                                        <span class="s1">editor</span><span class="s2">.</span><span class="s1">apply</span><span class="s2">();</span>

                                        <span class="s1">Toast</span><span class="s2">.</span><span class="s1">makeText</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s4">&quot;User created successfully&quot;</span><span class="s2">, </span><span class="s1">Toast</span><span class="s2">.</span><span class="s1">LENGTH_SHORT</span><span class="s2">).</span><span class="s1">show</span><span class="s2">();</span>
                                        <span class="s1">Intent intent </span><span class="s2">= </span><span class="s0">new </span><span class="s1">Intent</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s1">DashboardActivity</span><span class="s2">.</span><span class="s0">class</span><span class="s2">);</span>
                                        <span class="s1">startActivity</span><span class="s2">(</span><span class="s1">intent</span><span class="s2">);</span>
                                        <span class="s1">finish</span><span class="s2">();</span>
                                    <span class="s2">});</span>
                                <span class="s2">})</span>
                                <span class="s2">.</span><span class="s1">addOnFailureListener</span><span class="s2">(</span><span class="s1">exception -&gt; </span><span class="s2">{</span>
                                    <span class="s1">Toast</span><span class="s2">.</span><span class="s1">makeText</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s4">&quot;Failed to upload profile picture&quot;</span><span class="s2">, </span><span class="s1">Toast</span><span class="s2">.</span><span class="s1">LENGTH_SHORT</span><span class="s2">).</span><span class="s1">show</span><span class="s2">();</span>
                                <span class="s2">});</span>
                    <span class="s2">} </span><span class="s0">else </span><span class="s2">{</span>
                        <span class="s1">String errorMessage </span><span class="s2">= </span><span class="s1">task</span><span class="s2">.</span><span class="s1">getException</span><span class="s2">().</span><span class="s1">getMessage</span><span class="s2">();</span>
                        <span class="s1">Toast</span><span class="s2">.</span><span class="s1">makeText</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s4">&quot;Error creating user: &quot; </span><span class="s2">+ </span><span class="s1">errorMessage</span><span class="s2">, </span><span class="s1">Toast</span><span class="s2">.</span><span class="s1">LENGTH_SHORT</span><span class="s2">).</span><span class="s1">show</span><span class="s2">();</span>
                    <span class="s2">}</span>
                <span class="s2">});</span>
    <span class="s2">}</span>
    <span class="s0">private void </span><span class="s1">initVars</span><span class="s2">() {</span>
        <span class="s3">//GUI</span>
        <span class="s1">login_page_login_page </span><span class="s2">= (</span><span class="s1">LinearLayout</span><span class="s2">)</span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">login_page_login_page</span><span class="s2">);</span>
        <span class="s1">login_page_register_page </span><span class="s2">= (</span><span class="s1">LinearLayout</span><span class="s2">)</span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">login_page_register_page</span><span class="s2">);</span>
        <span class="s1">edtEmail </span><span class="s2">=</span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">edtEmail</span><span class="s2">);</span>
        <span class="s1">edtPassword </span><span class="s2">=</span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">edtPassword</span><span class="s2">);</span>
        <span class="s1">btnLogin </span><span class="s2">=</span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">btnLogin</span><span class="s2">);</span>
        <span class="s1">sharedPreferences</span><span class="s2">=</span><span class="s1">getSharedPreferences</span><span class="s2">(</span><span class="s4">&quot;session&quot;</span><span class="s2">,</span><span class="s1">MODE_PRIVATE</span><span class="s2">);</span>

        <span class="s1">String ss</span><span class="s2">=</span><span class="s1">sharedPreferences</span><span class="s2">.</span><span class="s1">getString</span><span class="s2">(</span><span class="s4">&quot;email&quot;</span><span class="s2">,</span><span class="s4">&quot;0&quot;</span><span class="s2">);</span>

        <span class="s3">// Toast.makeText(this, &quot;&quot;+ss, Toast.LENGTH_SHORT).show();</span>

        <span class="s0">if</span><span class="s2">(</span><span class="s1">ss</span><span class="s2">!=</span><span class="s4">&quot;0&quot;</span><span class="s2">){</span>

            <span class="s1">Intent i </span><span class="s2">= </span><span class="s0">new </span><span class="s1">Intent</span><span class="s2">(</span><span class="s1">getApplicationContext</span><span class="s2">(), </span><span class="s1">DashboardActivity</span><span class="s2">.</span><span class="s0">class</span><span class="s2">);</span>
            <span class="s1">startActivity</span><span class="s2">(</span><span class="s1">i</span><span class="s2">);</span>
            <span class="s1">finish</span><span class="s2">();</span>

        <span class="s2">}</span>

        <span class="s1">firebaseAuth </span><span class="s2">= </span><span class="s1">FirebaseAuth</span><span class="s2">.</span><span class="s1">getInstance</span><span class="s2">();</span>

        <span class="s1">fabButton</span><span class="s2">();</span>

        <span class="s1">btnLogin</span><span class="s2">.</span><span class="s1">setOnClickListener</span><span class="s2">(</span><span class="s0">new </span><span class="s1">View</span><span class="s2">.</span><span class="s1">OnClickListener</span><span class="s2">() {</span>
            <span class="s1">@Override</span>
            <span class="s0">public void </span><span class="s1">onClick</span><span class="s2">(</span><span class="s1">View view</span><span class="s2">) {</span>
                <span class="s0">if </span><span class="s2">(</span><span class="s1">validations</span><span class="s2">())</span>
                <span class="s2">{</span>
                    <span class="s1">login</span><span class="s2">();</span>
                <span class="s2">}</span>
            <span class="s2">}</span>
        <span class="s2">});</span>
    <span class="s2">}</span>

    <span class="s0">private boolean </span><span class="s1">loginLogin </span><span class="s2">= </span><span class="s0">true</span><span class="s2">;</span>

    <span class="s0">private void </span><span class="s1">fabButton</span><span class="s2">() {</span>
        <span class="s1">fab </span><span class="s2">= (</span><span class="s1">FloatingActionButton</span><span class="s2">)</span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">login_student_fab_btn</span><span class="s2">);</span>
        <span class="s1">fab</span><span class="s2">.</span><span class="s1">setOnClickListener</span><span class="s2">(</span><span class="s0">new </span><span class="s1">View</span><span class="s2">.</span><span class="s1">OnClickListener</span><span class="s2">() {</span>
            <span class="s1">@Override</span>
            <span class="s0">public void </span><span class="s1">onClick</span><span class="s2">(</span><span class="s1">View v</span><span class="s2">) {</span>
                <span class="s0">if </span><span class="s2">(</span><span class="s1">loginLogin</span><span class="s2">) {</span>
                    <span class="s3">//Open Reg Page</span>

                    <span class="s1">Animator circularReveal </span><span class="s2">= </span><span class="s1">ViewAnimationUtils</span>
                            <span class="s2">.</span><span class="s1">createCircularReveal</span><span class="s2">(</span><span class="s1">login_page_register_page</span><span class="s2">, (</span><span class="s1">login_page_register_page</span><span class="s2">.</span><span class="s1">getWidth</span><span class="s2">() - </span><span class="s5">200</span><span class="s2">), </span><span class="s5">150</span><span class="s2">, </span><span class="s5">0</span><span class="s2">, (</span><span class="s1">login_page_register_page</span><span class="s2">.</span><span class="s1">getHeight</span><span class="s2">() + </span><span class="s5">100</span><span class="s2">));</span>
                    <span class="s1">circularReveal</span><span class="s2">.</span><span class="s1">setDuration</span><span class="s2">(</span><span class="s5">600</span><span class="s2">);</span>
                    <span class="s1">circularReveal</span><span class="s2">.</span><span class="s1">setStartDelay</span><span class="s2">(</span><span class="s5">190</span><span class="s2">);</span>
                    <span class="s1">circularReveal</span><span class="s2">.</span><span class="s1">setInterpolator</span><span class="s2">(</span><span class="s0">new </span><span class="s1">DecelerateInterpolator</span><span class="s2">());</span>
                    <span class="s1">circularReveal</span><span class="s2">.</span><span class="s1">start</span><span class="s2">();</span>

                    <span class="s1">fab</span><span class="s2">.</span><span class="s1">animate</span><span class="s2">().</span><span class="s1">setInterpolator</span><span class="s2">(</span><span class="s0">new </span><span class="s1">DecelerateInterpolator</span><span class="s2">())</span>
                            <span class="s2">.</span><span class="s1">setDuration</span><span class="s2">(</span><span class="s5">600</span><span class="s2">).</span><span class="s1">translationY</span><span class="s2">(</span><span class="s5">50</span><span class="s2">)</span>
                            <span class="s2">.</span><span class="s1">translationX</span><span class="s2">(-</span><span class="s5">100</span><span class="s2">)</span>
                            <span class="s2">.</span><span class="s1">rotation</span><span class="s2">(</span><span class="s5">135</span><span class="s2">).</span><span class="s1">start</span><span class="s2">();</span>

                    <span class="s1">Handler hnd </span><span class="s2">= </span><span class="s0">new </span><span class="s1">Handler</span><span class="s2">(</span><span class="s1">Looper</span><span class="s2">.</span><span class="s1">getMainLooper</span><span class="s2">());</span>
                    <span class="s1">hnd</span><span class="s2">.</span><span class="s1">postDelayed</span><span class="s2">(</span><span class="s0">new </span><span class="s1">Runnable</span><span class="s2">() {</span>
                        <span class="s1">@RequiresApi</span><span class="s2">(</span><span class="s1">api </span><span class="s2">= </span><span class="s1">Build</span><span class="s2">.</span><span class="s1">VERSION_CODES</span><span class="s2">.</span><span class="s1">LOLLIPOP</span><span class="s2">)</span>
                        <span class="s1">@Override</span>
                        <span class="s0">public void </span><span class="s1">run</span><span class="s2">() {</span>
                            <span class="s1">login_page_login_page</span><span class="s2">.</span><span class="s1">setVisibility</span><span class="s2">(</span><span class="s1">View</span><span class="s2">.</span><span class="s1">INVISIBLE</span><span class="s2">);</span>
                            <span class="s1">login_page_register_page</span><span class="s2">.</span><span class="s1">setVisibility</span><span class="s2">(</span><span class="s1">View</span><span class="s2">.</span><span class="s1">VISIBLE</span><span class="s2">);</span>
                            <span class="s1">fab</span><span class="s2">.</span><span class="s1">setElevation</span><span class="s2">(</span><span class="s5">0</span><span class="s2">);</span>
                        <span class="s2">}</span>
                    <span class="s2">}, </span><span class="s5">200</span><span class="s2">);</span>

                    <span class="s1">loginLogin </span><span class="s2">= </span><span class="s0">false</span><span class="s2">;</span>
                <span class="s2">} </span><span class="s0">else </span><span class="s2">{</span>
                    <span class="s1">login_page_login_page</span><span class="s2">.</span><span class="s1">setVisibility</span><span class="s2">(</span><span class="s1">View</span><span class="s2">.</span><span class="s1">VISIBLE</span><span class="s2">);</span>
                    <span class="s1">login_page_register_page</span><span class="s2">.</span><span class="s1">setVisibility</span><span class="s2">(</span><span class="s1">View</span><span class="s2">.</span><span class="s1">INVISIBLE</span><span class="s2">);</span>

                    <span class="s1">Animator circularReveal </span><span class="s2">= </span><span class="s1">ViewAnimationUtils</span>
                            <span class="s2">.</span><span class="s1">createCircularReveal</span><span class="s2">(</span><span class="s1">login_page_login_page</span><span class="s2">, (</span><span class="s1">login_page_login_page</span><span class="s2">.</span><span class="s1">getWidth</span><span class="s2">() - </span><span class="s5">200</span><span class="s2">), </span><span class="s5">150</span><span class="s2">, </span><span class="s5">0</span><span class="s2">, (</span><span class="s1">login_page_login_page</span><span class="s2">.</span><span class="s1">getHeight</span><span class="s2">() + </span><span class="s5">100</span><span class="s2">));</span>
                    <span class="s1">circularReveal</span><span class="s2">.</span><span class="s1">setDuration</span><span class="s2">(</span><span class="s5">600</span><span class="s2">);</span>
                    <span class="s1">circularReveal</span><span class="s2">.</span><span class="s1">setInterpolator</span><span class="s2">(</span><span class="s0">new </span><span class="s1">DecelerateInterpolator</span><span class="s2">());</span>
                    <span class="s1">circularReveal</span><span class="s2">.</span><span class="s1">start</span><span class="s2">();</span>

                    <span class="s1">fab</span><span class="s2">.</span><span class="s1">animate</span><span class="s2">().</span><span class="s1">setInterpolator</span><span class="s2">(</span><span class="s0">new </span><span class="s1">DecelerateInterpolator</span><span class="s2">())</span>
                            <span class="s2">.</span><span class="s1">setDuration</span><span class="s2">(</span><span class="s5">200</span><span class="s2">).</span><span class="s1">translationY</span><span class="s2">(</span><span class="s5">0</span><span class="s2">)</span>
                            <span class="s2">.</span><span class="s1">translationX</span><span class="s2">(</span><span class="s5">0</span><span class="s2">)</span>
                            <span class="s2">.</span><span class="s1">rotation</span><span class="s2">(</span><span class="s5">0</span><span class="s2">).</span><span class="s1">start</span><span class="s2">();</span>

                    <span class="s1">Handler hnd </span><span class="s2">= </span><span class="s0">new </span><span class="s1">Handler</span><span class="s2">(</span><span class="s1">Looper</span><span class="s2">.</span><span class="s1">getMainLooper</span><span class="s2">());</span>
                    <span class="s1">hnd</span><span class="s2">.</span><span class="s1">postDelayed</span><span class="s2">(</span><span class="s0">new </span><span class="s1">Runnable</span><span class="s2">() {</span>
                        <span class="s1">@Override</span>
                        <span class="s0">public void </span><span class="s1">run</span><span class="s2">() {</span>
                            <span class="s1">login_page_login_page</span><span class="s2">.</span><span class="s1">setVisibility</span><span class="s2">(</span><span class="s1">View</span><span class="s2">.</span><span class="s1">VISIBLE</span><span class="s2">);</span>
                            <span class="s1">login_page_register_page</span><span class="s2">.</span><span class="s1">setVisibility</span><span class="s2">(</span><span class="s1">View</span><span class="s2">.</span><span class="s1">INVISIBLE</span><span class="s2">);</span>
                            <span class="s1">fab</span><span class="s2">.</span><span class="s1">setElevation</span><span class="s2">(</span><span class="s5">4</span><span class="s2">);</span>
                        <span class="s2">}</span>
                    <span class="s2">}, </span><span class="s5">200</span><span class="s2">);</span>

                    <span class="s1">loginLogin </span><span class="s2">= </span><span class="s0">true</span><span class="s2">;</span>
                <span class="s2">}</span>
            <span class="s2">}</span>
        <span class="s2">});</span>
    <span class="s2">}</span>

    <span class="s0">private void </span><span class="s1">login</span><span class="s2">() {</span>
        <span class="s1">String email </span><span class="s2">= </span><span class="s1">edtEmail</span><span class="s2">.</span><span class="s1">getText</span><span class="s2">().</span><span class="s1">toString</span><span class="s2">().</span><span class="s1">trim</span><span class="s2">();</span>
        <span class="s1">String password </span><span class="s2">= </span><span class="s1">edtPassword</span><span class="s2">.</span><span class="s1">getText</span><span class="s2">().</span><span class="s1">toString</span><span class="s2">();</span>

        <span class="s1">firebaseAuth</span><span class="s2">.</span><span class="s1">signInWithEmailAndPassword</span><span class="s2">(</span><span class="s1">email</span><span class="s2">, </span><span class="s1">password</span><span class="s2">)</span>
                <span class="s2">.</span><span class="s1">addOnCompleteListener</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s1">task -&gt; </span><span class="s2">{</span>
                    <span class="s0">if </span><span class="s2">(</span><span class="s1">task</span><span class="s2">.</span><span class="s1">isSuccessful</span><span class="s2">()) {</span>
                        <span class="s1">Toast</span><span class="s2">.</span><span class="s1">makeText</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s4">&quot;Login Successfully&quot;</span><span class="s2">, </span><span class="s1">Toast</span><span class="s2">.</span><span class="s1">LENGTH_SHORT</span><span class="s2">).</span><span class="s1">show</span><span class="s2">();</span>
                        <span class="s1">SharedPreferences</span><span class="s2">.</span><span class="s1">Editor editor</span><span class="s2">=</span><span class="s1">sharedPreferences</span><span class="s2">.</span><span class="s1">edit</span><span class="s2">();</span>
                        <span class="s1">editor</span><span class="s2">.</span><span class="s1">putString</span><span class="s2">(</span><span class="s4">&quot;email&quot;</span><span class="s2">,</span><span class="s1">email</span><span class="s2">);</span>
                        <span class="s1">editor</span><span class="s2">.</span><span class="s1">apply</span><span class="s2">();</span>


                        <span class="s1">startActivity</span><span class="s2">(</span><span class="s0">new </span><span class="s1">Intent</span><span class="s2">(</span><span class="s1">LoginActivity</span><span class="s2">.</span><span class="s0">this</span><span class="s2">, </span><span class="s1">DashboardActivity</span><span class="s2">.</span><span class="s0">class</span><span class="s2">));</span>
                        <span class="s3">// Perform success actions (e.g., navigate to another activity)</span>
                    <span class="s2">} </span><span class="s0">else </span><span class="s2">{</span>
                        <span class="s1">Toast</span><span class="s2">.</span><span class="s1">makeText</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s4">&quot;Invalid Credentials&quot;</span><span class="s2">, </span><span class="s1">Toast</span><span class="s2">.</span><span class="s1">LENGTH_SHORT</span><span class="s2">).</span><span class="s1">show</span><span class="s2">();</span>

                        <span class="s3">// Handle failure (e.g., display an error message)</span>
                    <span class="s2">}</span>
                <span class="s2">});</span>
    <span class="s2">}</span>
    <span class="s1">@Override</span>
    <span class="s0">protected void </span><span class="s1">onActivityResult</span><span class="s2">(</span><span class="s0">int </span><span class="s1">requestCode</span><span class="s2">, </span><span class="s0">int </span><span class="s1">resultCode</span><span class="s2">, </span><span class="s1">Intent data</span><span class="s2">) {</span>
        <span class="s0">super</span><span class="s2">.</span><span class="s1">onActivityResult</span><span class="s2">(</span><span class="s1">requestCode</span><span class="s2">, </span><span class="s1">resultCode</span><span class="s2">, </span><span class="s1">data</span><span class="s2">);</span>

        <span class="s0">if </span><span class="s2">(</span><span class="s1">requestCode </span><span class="s2">== </span><span class="s1">PICK_IMAGE_REQUEST </span><span class="s2">&amp;&amp; </span><span class="s1">resultCode </span><span class="s2">== </span><span class="s1">RESULT_OK </span><span class="s2">&amp;&amp; </span><span class="s1">data </span><span class="s2">!= </span><span class="s0">null</span><span class="s2">) {</span>
            <span class="s1">selectedImageUri </span><span class="s2">= </span><span class="s1">data</span><span class="s2">.</span><span class="s1">getData</span><span class="s2">();</span>
            <span class="s1">imgProfilePicture</span><span class="s2">.</span><span class="s1">setImageURI</span><span class="s2">(</span><span class="s1">selectedImageUri</span><span class="s2">);</span>
            <span class="s1">profilePictureUrl </span><span class="s2">= </span><span class="s1">selectedImageUri</span><span class="s2">.</span><span class="s1">toString</span><span class="s2">();</span>
        <span class="s2">}</span>
    <span class="s2">}</span>

    <span class="s0">private boolean </span><span class="s1">validations</span><span class="s2">() {</span>
        <span class="s0">if </span><span class="s2">(</span><span class="s1">edtEmail</span><span class="s2">.</span><span class="s1">getText</span><span class="s2">().</span><span class="s1">toString</span><span class="s2">().</span><span class="s1">isEmpty</span><span class="s2">())</span>
        <span class="s2">{</span>
            <span class="s1">Toast</span><span class="s2">.</span><span class="s1">makeText</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s4">&quot;Please enter email&quot;</span><span class="s2">, </span><span class="s1">Toast</span><span class="s2">.</span><span class="s1">LENGTH_SHORT</span><span class="s2">).</span><span class="s1">show</span><span class="s2">();</span>
            <span class="s0">return false</span><span class="s2">;</span>
        <span class="s2">}</span>
        <span class="s0">else if </span><span class="s2">(</span><span class="s1">edtPassword</span><span class="s2">.</span><span class="s1">getText</span><span class="s2">().</span><span class="s1">toString</span><span class="s2">().</span><span class="s1">isEmpty</span><span class="s2">())</span>
        <span class="s2">{</span>
            <span class="s1">Toast</span><span class="s2">.</span><span class="s1">makeText</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s4">&quot;Please enter Password&quot;</span><span class="s2">, </span><span class="s1">Toast</span><span class="s2">.</span><span class="s1">LENGTH_SHORT</span><span class="s2">).</span><span class="s1">show</span><span class="s2">();</span>
            <span class="s0">return false</span><span class="s2">;</span>
        <span class="s2">}</span>
        <span class="s0">else </span><span class="s2">{</span>
            <span class="s0">return true</span><span class="s2">;</span>
        <span class="s2">}</span>
    <span class="s2">}</span>
<span class="s2">}</span></pre>
</body>
</html>
