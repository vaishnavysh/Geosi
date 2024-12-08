<html>
<head>
<title>DashboardActivity.java</title>
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
DashboardActivity.java</font>
</center></td></tr></table>
<pre><span class="s0">package </span><span class="s1">com</span><span class="s2">.</span><span class="s1">alpha</span><span class="s2">.</span><span class="s1">silentme</span><span class="s2">;</span>

<span class="s0">import static </span><span class="s1">com</span><span class="s2">.</span><span class="s1">alpha</span><span class="s2">.</span><span class="s1">silentme</span><span class="s2">.</span><span class="s1">consts</span><span class="s2">.</span><span class="s1">Constants</span><span class="s2">.</span><span class="s1">CONST_COLLEGE_NAME</span><span class="s2">;</span>
<span class="s0">import static </span><span class="s1">com</span><span class="s2">.</span><span class="s1">alpha</span><span class="s2">.</span><span class="s1">silentme</span><span class="s2">.</span><span class="s1">consts</span><span class="s2">.</span><span class="s1">Constants</span><span class="s2">.</span><span class="s1">CONST_CURRENT_EMAIL</span><span class="s2">;</span>
<span class="s0">import static </span><span class="s1">com</span><span class="s2">.</span><span class="s1">alpha</span><span class="s2">.</span><span class="s1">silentme</span><span class="s2">.</span><span class="s1">consts</span><span class="s2">.</span><span class="s1">Constants</span><span class="s2">.</span><span class="s1">CONST_NAME</span><span class="s2">;</span>
<span class="s0">import static </span><span class="s1">com</span><span class="s2">.</span><span class="s1">alpha</span><span class="s2">.</span><span class="s1">silentme</span><span class="s2">.</span><span class="s1">consts</span><span class="s2">.</span><span class="s1">Constants</span><span class="s2">.</span><span class="s1">MYUUID</span><span class="s2">;</span>

<span class="s0">import </span><span class="s1">androidx</span><span class="s2">.</span><span class="s1">annotation</span><span class="s2">.</span><span class="s1">NonNull</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">androidx</span><span class="s2">.</span><span class="s1">appcompat</span><span class="s2">.</span><span class="s1">app</span><span class="s2">.</span><span class="s1">AppCompatActivity</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">androidx</span><span class="s2">.</span><span class="s1">cardview</span><span class="s2">.</span><span class="s1">widget</span><span class="s2">.</span><span class="s1">CardView</span><span class="s2">;</span>

<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">app</span><span class="s2">.</span><span class="s1">Dialog</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">content</span><span class="s2">.</span><span class="s1">Intent</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">content</span><span class="s2">.</span><span class="s1">SharedPreferences</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">net</span><span class="s2">.</span><span class="s1">Uri</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">os</span><span class="s2">.</span><span class="s1">Bundle</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">provider</span><span class="s2">.</span><span class="s1">Settings</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">util</span><span class="s2">.</span><span class="s1">Log</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">view</span><span class="s2">.</span><span class="s1">View</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">widget</span><span class="s2">.</span><span class="s1">ImageButton</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">widget</span><span class="s2">.</span><span class="s1">ImageView</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">widget</span><span class="s2">.</span><span class="s1">TextView</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">android</span><span class="s2">.</span><span class="s1">widget</span><span class="s2">.</span><span class="s1">Toast</span><span class="s2">;</span>

<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">alpha</span><span class="s2">.</span><span class="s1">silentme</span><span class="s2">.</span><span class="s1">bean</span><span class="s2">.</span><span class="s1">User</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">alpha</span><span class="s2">.</span><span class="s1">silentme</span><span class="s2">.</span><span class="s1">chathead</span><span class="s2">.</span><span class="s1">FloatingViewService</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">alpha</span><span class="s2">.</span><span class="s1">silentme</span><span class="s2">.</span><span class="s1">consts</span><span class="s2">.</span><span class="s1">Constants</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">alpha</span><span class="s2">.</span><span class="s1">silentme</span><span class="s2">.</span><span class="s1">firebase_chat</span><span class="s2">.</span><span class="s1">ChatListActivity</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">bumptech</span><span class="s2">.</span><span class="s1">glide</span><span class="s2">.</span><span class="s1">Glide</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">android</span><span class="s2">.</span><span class="s1">material</span><span class="s2">.</span><span class="s1">floatingactionbutton</span><span class="s2">.</span><span class="s1">FloatingActionButton</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">firebase</span><span class="s2">.</span><span class="s1">auth</span><span class="s2">.</span><span class="s1">FirebaseAuth</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">firebase</span><span class="s2">.</span><span class="s1">auth</span><span class="s2">.</span><span class="s1">FirebaseUser</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">firebase</span><span class="s2">.</span><span class="s1">database</span><span class="s2">.</span><span class="s1">DataSnapshot</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">firebase</span><span class="s2">.</span><span class="s1">database</span><span class="s2">.</span><span class="s1">DatabaseError</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">firebase</span><span class="s2">.</span><span class="s1">database</span><span class="s2">.</span><span class="s1">DatabaseReference</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">firebase</span><span class="s2">.</span><span class="s1">database</span><span class="s2">.</span><span class="s1">FirebaseDatabase</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">firebase</span><span class="s2">.</span><span class="s1">database</span><span class="s2">.</span><span class="s1">ValueEventListener</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">firebase</span><span class="s2">.</span><span class="s1">storage</span><span class="s2">.</span><span class="s1">FirebaseStorage</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">com</span><span class="s2">.</span><span class="s1">google</span><span class="s2">.</span><span class="s1">firebase</span><span class="s2">.</span><span class="s1">storage</span><span class="s2">.</span><span class="s1">StorageReference</span><span class="s2">;</span>

<span class="s0">public class </span><span class="s1">DashboardActivity </span><span class="s0">extends </span><span class="s1">AppCompatActivity </span><span class="s2">{</span>

    <span class="s3">//Test</span>
    <span class="s1">CardView btnSetLocation</span><span class="s2">;</span>
    <span class="s1">FloatingActionButton formChat</span><span class="s2">;</span>
    <span class="s1">ImageView imgProfilePicture</span><span class="s2">;</span>
    <span class="s1">SharedPreferences sharedPreferences</span><span class="s2">;</span>
    <span class="s0">private static final int </span><span class="s1">CODE_DRAW_OVER_OTHER_APP_PERMISSION </span><span class="s2">= </span><span class="s4">2084</span><span class="s2">;</span>
    <span class="s0">private </span><span class="s1">TextView txtUserName</span><span class="s2">;</span>
    <span class="s0">private </span><span class="s1">FirebaseAuth firebaseAuth</span><span class="s2">;</span>
    <span class="s0">private </span><span class="s1">DatabaseReference usersReference</span><span class="s2">;</span>
    <span class="s0">private </span><span class="s1">TextView txtEmailForm</span><span class="s2">;</span>
    <span class="s0">private </span><span class="s1">TextView txtUserNameForm</span><span class="s2">;</span>
    <span class="s0">private </span><span class="s1">TextView txtVirtualIDForm</span><span class="s2">;</span>
    <span class="s0">private </span><span class="s1">TextView txtCollegeForm</span><span class="s2">;</span>
    <span class="s0">private </span><span class="s1">CardView formContainer</span><span class="s2">;</span>
    <span class="s0">private </span><span class="s1">ImageButton Virtuaclosebutton</span><span class="s2">;</span>
    <span class="s0">private </span><span class="s1">String stUserName</span><span class="s2">=</span><span class="s5">&quot;&quot;</span><span class="s2">,</span><span class="s1">stEmail</span><span class="s2">=</span><span class="s5">&quot;&quot;</span><span class="s2">,</span><span class="s1">stVirtualID</span><span class="s2">=</span><span class="s5">&quot;&quot;</span><span class="s2">,</span><span class="s1">college</span><span class="s2">=</span><span class="s5">&quot;&quot;</span><span class="s2">,</span><span class="s1">stId</span><span class="s2">=</span><span class="s5">&quot;&quot;</span><span class="s2">;</span>


    <span class="s1">@Override</span>
    <span class="s0">protected void </span><span class="s1">onCreate</span><span class="s2">(</span><span class="s1">Bundle savedInstanceState</span><span class="s2">) {</span>
        <span class="s0">super</span><span class="s2">.</span><span class="s1">onCreate</span><span class="s2">(</span><span class="s1">savedInstanceState</span><span class="s2">);</span>
        <span class="s1">setContentView</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">layout</span><span class="s2">.</span><span class="s1">activity_dashboard</span><span class="s2">);</span>

        <span class="s1">initVar</span><span class="s2">();</span>

        <span class="s1">setMethods</span><span class="s2">();</span>

        <span class="s1">sharedlogout</span><span class="s2">();</span>


        <span class="s1">loadUserInfo</span><span class="s2">(); </span><span class="s3">// Load user's name from Firebase</span>
    <span class="s2">}</span>

    <span class="s0">private void </span><span class="s1">sharedlogout</span><span class="s2">() {</span>
        <span class="s1">ImageButton btnLogout </span><span class="s2">= </span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">btnLogout</span><span class="s2">);</span>
        <span class="s1">btnLogout</span><span class="s2">.</span><span class="s1">setOnClickListener</span><span class="s2">(</span><span class="s1">view -&gt; </span><span class="s2">{</span>
            <span class="s3">// Clear the SharedPreferences and navigate to LoginActivity</span>
            <span class="s1">SharedPreferences</span><span class="s2">.</span><span class="s1">Editor editor</span><span class="s2">=</span><span class="s1">sharedPreferences</span><span class="s2">.</span><span class="s1">edit</span><span class="s2">();</span>
            <span class="s1">editor</span><span class="s2">.</span><span class="s1">remove</span><span class="s2">(</span><span class="s5">&quot;email&quot;</span><span class="s2">);</span>
            <span class="s1">editor</span><span class="s2">.</span><span class="s1">commit</span><span class="s2">();</span>
            <span class="s1">Intent i </span><span class="s2">= </span><span class="s0">new </span><span class="s1">Intent</span><span class="s2">(</span><span class="s1">getApplicationContext</span><span class="s2">(), </span><span class="s1">LoginActivity</span><span class="s2">.</span><span class="s0">class</span><span class="s2">);</span>
            <span class="s1">startActivity</span><span class="s2">(</span><span class="s1">i</span><span class="s2">);</span>
            <span class="s1">finish</span><span class="s2">();</span>
        <span class="s2">});</span>
    <span class="s2">}</span>

    <span class="s0">private void </span><span class="s1">setMethods</span><span class="s2">() {</span>

        <span class="s1">formContainer</span><span class="s2">.</span><span class="s1">setOnClickListener</span><span class="s2">(</span><span class="s1">view -&gt; </span><span class="s2">{</span>
            <span class="s1">Log</span><span class="s2">.</span><span class="s1">e</span><span class="s2">(</span><span class="s5">&quot;Bacl&quot;</span><span class="s2">,</span><span class="s5">&quot;asds&quot;</span><span class="s2">);</span>
            <span class="s3">// Call the method to load user info from Firebase and display in dialog</span>
            <span class="s1">showUserInfoDialog</span><span class="s2">(</span><span class="s1">stUserName</span><span class="s2">,</span><span class="s1">stEmail</span><span class="s2">,</span><span class="s1">stVirtualID</span><span class="s2">,</span><span class="s1">college</span><span class="s2">);</span>
        <span class="s2">});</span>

        <span class="s1">btnSetLocation</span><span class="s2">.</span><span class="s1">setOnClickListener</span><span class="s2">(</span><span class="s0">new </span><span class="s1">View</span><span class="s2">.</span><span class="s1">OnClickListener</span><span class="s2">() {</span>
            <span class="s1">@Override</span>
            <span class="s0">public void </span><span class="s1">onClick</span><span class="s2">(</span><span class="s1">View view</span><span class="s2">) {</span>
                <span class="s1">startActivity</span><span class="s2">(</span><span class="s0">new </span><span class="s1">Intent</span><span class="s2">(</span><span class="s1">DashboardActivity</span><span class="s2">.</span><span class="s0">this</span><span class="s2">,</span><span class="s1">MainActivity</span><span class="s2">.</span><span class="s0">class</span><span class="s2">));</span>
            <span class="s2">}</span>
        <span class="s2">});</span>

        <span class="s1">imgProfilePicture</span><span class="s2">.</span><span class="s1">setOnClickListener</span><span class="s2">(</span><span class="s1">view -&gt; </span><span class="s2">{</span>
            <span class="s3">// Create a custom dialog for image display</span>
            <span class="s0">final </span><span class="s1">Dialog imageDialog </span><span class="s2">= </span><span class="s0">new </span><span class="s1">Dialog</span><span class="s2">(</span><span class="s1">DashboardActivity</span><span class="s2">.</span><span class="s0">this</span><span class="s2">);</span>
            <span class="s1">imageDialog</span><span class="s2">.</span><span class="s1">setContentView</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">layout</span><span class="s2">.</span><span class="s1">dialog_image_display</span><span class="s2">);</span>

            <span class="s3">// Get the ImageView from the dialog layout</span>
            <span class="s1">ImageView dialogImageView </span><span class="s2">= </span><span class="s1">imageDialog</span><span class="s2">.</span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">dialogImageView</span><span class="s2">);</span>

            <span class="s3">// Load and display the user's profile picture using Glide</span>
            <span class="s1">FirebaseUser user </span><span class="s2">= </span><span class="s1">FirebaseAuth</span><span class="s2">.</span><span class="s1">getInstance</span><span class="s2">().</span><span class="s1">getCurrentUser</span><span class="s2">();</span>
            <span class="s0">if </span><span class="s2">(</span><span class="s1">user </span><span class="s2">!= </span><span class="s0">null</span><span class="s2">) {</span>
                <span class="s1">String userId </span><span class="s2">= </span><span class="s1">user</span><span class="s2">.</span><span class="s1">getUid</span><span class="s2">();</span>
                <span class="s1">String profilePictureRef </span><span class="s2">= </span><span class="s5">&quot;profile_pictures/&quot; </span><span class="s2">+ </span><span class="s1">userId</span><span class="s2">;</span>

                <span class="s1">FirebaseStorage storage </span><span class="s2">= </span><span class="s1">FirebaseStorage</span><span class="s2">.</span><span class="s1">getInstance</span><span class="s2">();</span>
                <span class="s1">StorageReference storageRef </span><span class="s2">= </span><span class="s1">storage</span><span class="s2">.</span><span class="s1">getReference</span><span class="s2">();</span>
                <span class="s1">storageRef</span><span class="s2">.</span><span class="s1">child</span><span class="s2">(</span><span class="s1">profilePictureRef</span><span class="s2">).</span><span class="s1">getDownloadUrl</span><span class="s2">().</span><span class="s1">addOnSuccessListener</span><span class="s2">(</span><span class="s1">uri -&gt; </span><span class="s2">{</span>
                    <span class="s1">Glide</span><span class="s2">.</span><span class="s1">with</span><span class="s2">(</span><span class="s1">DashboardActivity</span><span class="s2">.</span><span class="s0">this</span><span class="s2">)</span>
                            <span class="s2">.</span><span class="s1">load</span><span class="s2">(</span><span class="s1">uri</span><span class="s2">)</span>
                            <span class="s2">.</span><span class="s1">into</span><span class="s2">(</span><span class="s1">dialogImageView</span><span class="s2">);</span>
                <span class="s2">}).</span><span class="s1">addOnFailureListener</span><span class="s2">(</span><span class="s1">exception -&gt; </span><span class="s2">{</span>
                    <span class="s3">// Handle failure to retrieve the download URL</span>
                    <span class="s3">// You can set a placeholder image or handle the error accordingly</span>
                    <span class="s1">dialogImageView</span><span class="s2">.</span><span class="s1">setImageResource</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">drawable</span><span class="s2">.</span><span class="s1">image_user</span><span class="s2">);</span>
                <span class="s2">});</span>
            <span class="s2">}</span>

            <span class="s3">// Set up click listener for the close button</span>
            <span class="s1">ImageButton btnClose </span><span class="s2">= </span><span class="s1">imageDialog</span><span class="s2">.</span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">btnClose</span><span class="s2">);</span>
            <span class="s1">btnClose</span><span class="s2">.</span><span class="s1">setOnClickListener</span><span class="s2">(</span><span class="s1">closeView -&gt; imageDialog</span><span class="s2">.</span><span class="s1">dismiss</span><span class="s2">());</span>

            <span class="s3">// Show the dialog</span>
            <span class="s1">imageDialog</span><span class="s2">.</span><span class="s1">show</span><span class="s2">();</span>
        <span class="s2">});</span>

        <span class="s1">loadAndDisplayProfilePicture</span><span class="s2">();</span>
    <span class="s2">}</span>

    <span class="s0">private void </span><span class="s1">loadAndDisplayProfilePicture</span><span class="s2">() {</span>
        <span class="s1">FirebaseUser user </span><span class="s2">= </span><span class="s1">FirebaseAuth</span><span class="s2">.</span><span class="s1">getInstance</span><span class="s2">().</span><span class="s1">getCurrentUser</span><span class="s2">();</span>

        <span class="s0">if </span><span class="s2">(</span><span class="s1">user </span><span class="s2">!= </span><span class="s0">null</span><span class="s2">) {</span>
            <span class="s1">String userId </span><span class="s2">= </span><span class="s1">user</span><span class="s2">.</span><span class="s1">getUid</span><span class="s2">();</span>

            <span class="s3">// Construct the reference to the user's profile picture in Firebase Storage</span>
            <span class="s3">// Assuming you are using &quot;profile_pictures&quot; as the storage path</span>
            <span class="s1">String profilePictureRef </span><span class="s2">= </span><span class="s5">&quot;profile_pictures/&quot; </span><span class="s2">+ </span><span class="s1">userId</span><span class="s2">;</span>

            <span class="s3">// Get the download URL for the profile picture</span>
            <span class="s1">FirebaseStorage storage </span><span class="s2">= </span><span class="s1">FirebaseStorage</span><span class="s2">.</span><span class="s1">getInstance</span><span class="s2">();</span>
            <span class="s1">StorageReference storageRef </span><span class="s2">= </span><span class="s1">storage</span><span class="s2">.</span><span class="s1">getReference</span><span class="s2">();</span>
            <span class="s1">storageRef</span><span class="s2">.</span><span class="s1">child</span><span class="s2">(</span><span class="s1">profilePictureRef</span><span class="s2">).</span><span class="s1">getDownloadUrl</span><span class="s2">().</span><span class="s1">addOnSuccessListener</span><span class="s2">(</span><span class="s1">uri -&gt; </span><span class="s2">{</span>
                <span class="s3">// Load the image using Glide and display it in the ImageView</span>
                <span class="s1">Glide</span><span class="s2">.</span><span class="s1">with</span><span class="s2">(</span><span class="s0">this</span><span class="s2">)</span>
                        <span class="s2">.</span><span class="s1">load</span><span class="s2">(</span><span class="s1">uri</span><span class="s2">)</span>
                        <span class="s2">.</span><span class="s1">into</span><span class="s2">(</span><span class="s1">imgProfilePicture</span><span class="s2">);</span>
            <span class="s2">}).</span><span class="s1">addOnFailureListener</span><span class="s2">(</span><span class="s1">exception -&gt; </span><span class="s2">{</span>
                <span class="s3">// Handle failure to retrieve the download URL</span>
                <span class="s3">// You can set a placeholder image or handle the error accordingly</span>
                <span class="s1">imgProfilePicture</span><span class="s2">.</span><span class="s1">setImageResource</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">drawable</span><span class="s2">.</span><span class="s1">ic_launcher_background</span><span class="s2">);</span>
            <span class="s2">});</span>
        <span class="s2">}</span>
    <span class="s2">}</span>

    <span class="s0">private void </span><span class="s1">initVar</span><span class="s2">() {</span>
        <span class="s1">formContainer</span><span class="s2">=</span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">formContainer</span><span class="s2">);</span>
        <span class="s1">btnSetLocation</span><span class="s2">= </span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">btnSetLocation</span><span class="s2">);</span>
        <span class="s1">imgProfilePicture </span><span class="s2">= </span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">imgProfilePicture</span><span class="s2">);</span>
        <span class="s1">sharedPreferences </span><span class="s2">= </span><span class="s1">getSharedPreferences</span><span class="s2">(</span><span class="s5">&quot;session&quot;</span><span class="s2">, </span><span class="s1">MODE_PRIVATE</span><span class="s2">);</span>
        <span class="s1">String email</span><span class="s2">=</span><span class="s1">sharedPreferences</span><span class="s2">.</span><span class="s1">getString</span><span class="s2">(</span><span class="s5">&quot;email&quot;</span><span class="s2">,</span><span class="s5">&quot;0&quot;</span><span class="s2">);</span>
        <span class="s1">txtUserName </span><span class="s2">= </span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">txtUserName</span><span class="s2">);</span>
        <span class="s3">// Initialize FirebaseAuth and DatabaseReference</span>
        <span class="s1">firebaseAuth </span><span class="s2">= </span><span class="s1">FirebaseAuth</span><span class="s2">.</span><span class="s1">getInstance</span><span class="s2">();</span>
        <span class="s1">usersReference </span><span class="s2">= </span><span class="s1">FirebaseDatabase</span><span class="s2">.</span><span class="s1">getInstance</span><span class="s2">().</span><span class="s1">getReference</span><span class="s2">().</span><span class="s1">child</span><span class="s2">(</span><span class="s5">&quot;users&quot;</span><span class="s2">);</span>
        <span class="s1">txtUserNameForm </span><span class="s2">= </span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">userName</span><span class="s2">);</span>
        <span class="s1">txtEmailForm </span><span class="s2">= </span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">txtEmailForm</span><span class="s2">);</span>
        <span class="s1">txtVirtualIDForm </span><span class="s2">= </span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">txtVirtualIDForm</span><span class="s2">);</span>
        <span class="s1">txtCollegeForm</span><span class="s2">=</span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">txtCollegeForm</span><span class="s2">);</span>
        <span class="s1">Virtuaclosebutton</span><span class="s2">=</span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">vclose</span><span class="s2">);</span>

        <span class="s1">formChat</span><span class="s2">= </span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">formChat</span><span class="s2">);</span>
        <span class="s1">formChat</span><span class="s2">.</span><span class="s1">setOnClickListener</span><span class="s2">(</span><span class="s0">new </span><span class="s1">View</span><span class="s2">.</span><span class="s1">OnClickListener</span><span class="s2">() {</span>
            <span class="s1">@Override</span>
            <span class="s0">public void </span><span class="s1">onClick</span><span class="s2">(</span><span class="s1">View view</span><span class="s2">) {</span>
                <span class="s1">startActivity</span><span class="s2">(</span><span class="s0">new </span><span class="s1">Intent</span><span class="s2">(</span><span class="s1">DashboardActivity</span><span class="s2">.</span><span class="s0">this</span><span class="s2">, </span><span class="s1">ChatListActivity</span><span class="s2">.</span><span class="s0">class</span><span class="s2">));</span>
            <span class="s2">}</span>
        <span class="s2">});</span>

    <span class="s2">}</span>

    <span class="s0">private void </span><span class="s1">loadUserInfo</span><span class="s2">() {</span>
        <span class="s1">String userId </span><span class="s2">= </span><span class="s1">firebaseAuth</span><span class="s2">.</span><span class="s1">getCurrentUser</span><span class="s2">().</span><span class="s1">getUid</span><span class="s2">();</span>

        <span class="s1">usersReference</span><span class="s2">.</span><span class="s1">child</span><span class="s2">(</span><span class="s1">userId</span><span class="s2">).</span><span class="s1">addListenerForSingleValueEvent</span><span class="s2">(</span><span class="s0">new </span><span class="s1">ValueEventListener</span><span class="s2">() {</span>
            <span class="s1">@Override</span>
            <span class="s0">public void </span><span class="s1">onDataChange</span><span class="s2">(</span><span class="s1">@NonNull DataSnapshot dataSnapshot</span><span class="s2">) {</span>
                <span class="s0">if </span><span class="s2">(</span><span class="s1">dataSnapshot</span><span class="s2">.</span><span class="s1">exists</span><span class="s2">()) {</span>
                    <span class="s1">User user </span><span class="s2">= </span><span class="s1">dataSnapshot</span><span class="s2">.</span><span class="s1">getValue</span><span class="s2">(</span><span class="s1">User</span><span class="s2">.</span><span class="s0">class</span><span class="s2">);</span>
                    <span class="s0">if </span><span class="s2">(</span><span class="s1">user </span><span class="s2">!= </span><span class="s0">null</span><span class="s2">) {</span>
                        <span class="s1">stUserName </span><span class="s2">= </span><span class="s1">user</span><span class="s2">.</span><span class="s1">name</span><span class="s2">;</span>
                        <span class="s1">stEmail </span><span class="s2">= </span><span class="s1">user</span><span class="s2">.</span><span class="s1">email</span><span class="s2">;</span>
                        <span class="s1">stId </span><span class="s2">= </span><span class="s1">String</span><span class="s2">.</span><span class="s1">valueOf</span><span class="s2">(</span><span class="s1">user</span><span class="s2">.</span><span class="s1">id</span><span class="s2">);</span>
                        <span class="s1">stVirtualID </span><span class="s2">= </span><span class="s1">userId</span><span class="s2">;</span>
                        <span class="s1">college</span><span class="s2">=</span><span class="s1">user</span><span class="s2">.</span><span class="s1">college</span><span class="s2">;</span>

                        <span class="s1">Log</span><span class="s2">.</span><span class="s1">e</span><span class="s2">(</span><span class="s5">&quot;collega&quot;</span><span class="s2">,</span><span class="s1">college</span><span class="s2">);</span>

                        <span class="s1">MySharedPreferences</span><span class="s2">.</span><span class="s1">saveString</span><span class="s2">(</span><span class="s1">DashboardActivity</span><span class="s2">.</span><span class="s0">this</span><span class="s2">, </span><span class="s1">CONST_COLLEGE_NAME</span><span class="s2">,</span><span class="s1">college</span><span class="s2">);</span>
                        <span class="s1">MySharedPreferences</span><span class="s2">.</span><span class="s1">saveString</span><span class="s2">(</span><span class="s1">DashboardActivity</span><span class="s2">.</span><span class="s0">this</span><span class="s2">, </span><span class="s1">CONST_NAME</span><span class="s2">,</span><span class="s1">stUserName</span><span class="s2">);</span>
                        <span class="s1">MySharedPreferences</span><span class="s2">.</span><span class="s1">saveString</span><span class="s2">(</span><span class="s1">DashboardActivity</span><span class="s2">.</span><span class="s0">this</span><span class="s2">, </span><span class="s1">CONST_CURRENT_EMAIL</span><span class="s2">,</span><span class="s1">stEmail</span><span class="s2">);</span>
                        <span class="s1">MySharedPreferences</span><span class="s2">.</span><span class="s1">saveString</span><span class="s2">(</span><span class="s1">DashboardActivity</span><span class="s2">.</span><span class="s0">this</span><span class="s2">, </span><span class="s1">MYUUID</span><span class="s2">,</span><span class="s1">stId</span><span class="s2">);</span>
                        <span class="s1">txtUserName</span><span class="s2">.</span><span class="s1">setText</span><span class="s2">(</span><span class="s1">stUserName</span><span class="s2">); </span><span class="s3">// Set user's name in the TextView</span>
                    <span class="s2">}</span>
                <span class="s2">}</span>
            <span class="s2">}</span>

            <span class="s1">@Override</span>
            <span class="s0">public void </span><span class="s1">onCancelled</span><span class="s2">(</span><span class="s1">@NonNull DatabaseError databaseError</span><span class="s2">) {</span>
                <span class="s3">// Handle error if needed</span>
            <span class="s2">}</span>
        <span class="s2">});</span>
    <span class="s2">}</span>


    <span class="s0">private void </span><span class="s1">showUserInfoDialog</span><span class="s2">(</span><span class="s1">String userName</span><span class="s2">, </span><span class="s1">String userEmail</span><span class="s2">, </span><span class="s1">String virtualId</span><span class="s2">, </span><span class="s1">String college</span><span class="s2">) {</span>
        <span class="s3">// Create a custom dialog for displaying user information</span>
        <span class="s0">final </span><span class="s1">Dialog userInfoDialog </span><span class="s2">= </span><span class="s0">new </span><span class="s1">Dialog</span><span class="s2">(</span><span class="s1">DashboardActivity</span><span class="s2">.</span><span class="s0">this</span><span class="s2">);</span>
        <span class="s1">userInfoDialog</span><span class="s2">.</span><span class="s1">setContentView</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">layout</span><span class="s2">.</span><span class="s1">dialog_user_info</span><span class="s2">);</span>

        <span class="s3">// Get the TextViews from the dialog layout</span>
        <span class="s1">TextView txtUserNameDialog </span><span class="s2">= </span><span class="s1">userInfoDialog</span><span class="s2">.</span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">userName</span><span class="s2">);</span>
        <span class="s1">TextView txtEmailDialog </span><span class="s2">= </span><span class="s1">userInfoDialog</span><span class="s2">.</span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">txtEmailForm</span><span class="s2">);</span>
        <span class="s1">TextView txtCollegeDialog </span><span class="s2">= </span><span class="s1">userInfoDialog</span><span class="s2">.</span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">txtCollegeForm</span><span class="s2">);</span>
        <span class="s1">TextView txtVirtualIDDialog </span><span class="s2">= </span><span class="s1">userInfoDialog</span><span class="s2">.</span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">txtVirtualIDForm</span><span class="s2">);</span>


        <span class="s3">// Set user information in the TextViews</span>
        <span class="s1">txtUserNameDialog</span><span class="s2">.</span><span class="s1">setText</span><span class="s2">(</span><span class="s1">userName</span><span class="s2">);</span>
        <span class="s1">txtEmailDialog</span><span class="s2">.</span><span class="s1">setText</span><span class="s2">(</span><span class="s1">userEmail</span><span class="s2">);</span>
        <span class="s1">txtCollegeDialog</span><span class="s2">.</span><span class="s1">setText</span><span class="s2">(</span><span class="s1">college</span><span class="s2">);</span>
        <span class="s1">txtVirtualIDDialog</span><span class="s2">.</span><span class="s1">setText</span><span class="s2">(</span><span class="s5">&quot;Virtual ID: &quot; </span><span class="s2">+ </span><span class="s1">virtualId</span><span class="s2">);</span>

        <span class="s1">Virtuaclosebutton </span><span class="s2">= </span><span class="s1">userInfoDialog</span><span class="s2">.</span><span class="s1">findViewById</span><span class="s2">(</span><span class="s1">R</span><span class="s2">.</span><span class="s1">id</span><span class="s2">.</span><span class="s1">vclose</span><span class="s2">);</span>
        <span class="s1">Virtuaclosebutton</span><span class="s2">.</span><span class="s1">setOnClickListener</span><span class="s2">(</span><span class="s1">closeView -&gt; userInfoDialog</span><span class="s2">.</span><span class="s1">dismiss</span><span class="s2">());</span>


        <span class="s3">// Show the dialog</span>
        <span class="s1">userInfoDialog</span><span class="s2">.</span><span class="s1">show</span><span class="s2">();</span>
    <span class="s2">}</span>


    <span class="s1">@Override</span>
    <span class="s0">protected void </span><span class="s1">onActivityResult</span><span class="s2">(</span><span class="s0">int </span><span class="s1">requestCode</span><span class="s2">, </span><span class="s0">int </span><span class="s1">resultCode</span><span class="s2">, </span><span class="s1">Intent data</span><span class="s2">) {</span>
        <span class="s0">if </span><span class="s2">(</span><span class="s1">requestCode </span><span class="s2">== </span><span class="s1">CODE_DRAW_OVER_OTHER_APP_PERMISSION</span><span class="s2">) {</span>
            <span class="s3">//Check if the permission is granted or not.</span>
            <span class="s0">if </span><span class="s2">(</span><span class="s1">resultCode </span><span class="s2">== </span><span class="s1">RESULT_OK</span><span class="s2">)</span>
            <span class="s2">{</span>
                <span class="s1">startService</span><span class="s2">(</span><span class="s0">new </span><span class="s1">Intent</span><span class="s2">(</span><span class="s0">this</span><span class="s2">, </span><span class="s1">FloatingViewService</span><span class="s2">.</span><span class="s0">class</span><span class="s2">));</span>
                <span class="s3">//finish();</span>
            <span class="s2">} </span><span class="s0">else </span><span class="s2">{ </span><span class="s3">//Permission is not available</span>
                <span class="s1">Toast</span><span class="s2">.</span><span class="s1">makeText</span><span class="s2">(</span><span class="s0">this</span><span class="s2">,</span>
                        <span class="s5">&quot;Draw over other app permission not available. Closing the application&quot;</span><span class="s2">,</span>
                        <span class="s1">Toast</span><span class="s2">.</span><span class="s1">LENGTH_SHORT</span><span class="s2">).</span><span class="s1">show</span><span class="s2">();</span>

                <span class="s3">//finish();</span>
            <span class="s2">}</span>
        <span class="s2">} </span><span class="s0">else </span><span class="s2">{</span>
            <span class="s0">super</span><span class="s2">.</span><span class="s1">onActivityResult</span><span class="s2">(</span><span class="s1">requestCode</span><span class="s2">, </span><span class="s1">resultCode</span><span class="s2">, </span><span class="s1">data</span><span class="s2">);</span>
        <span class="s2">}</span>
    <span class="s2">}</span>

<span class="s2">}</span>
</pre>
</body>
</html>
