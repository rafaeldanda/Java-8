
// Your web app's Firebase configuration
var firebaseConfig = {
    apiKey: "AIzaSyBhMzKhVW4n8Nx8Yj_cHe4e_wazBo4joVY",
    authDomain: "rafael-teste-28940.firebaseapp.com",
    databaseURL: "https://rafael-teste-28940.firebaseio.com",
    projectId: "rafael-teste-28940",
    storageBucket: "rafael-teste-28940.appspot.com",
    messagingSenderId: "144143943781",
    appId: "1:144143943781:web:477b4c73dd553c686c1e8c"
};
// Initialize Firebase
firebase.initializeApp(firebaseConfig);

var admin = require("firebase-admin");

var serviceAccount = require("path/to/serviceAccountKey.json");

admin.initializeApp({
    credential: admin.credential.cert(serviceAccount),
    databaseURL: "https://rafael-teste-28940.firebaseio.com"
});
