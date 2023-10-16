<template>
  <div class="home">
    <!-- <input type="text" v-model="searchQuery">
    <button @click="search">Search</button> -->
    <!-- <form id=search-form>
      <div class="wrapper">
          <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="#FF0000">
          <path d="M15.5 14h-.79l-.28-.27C15.41 12.59 16 11.11 16 9.5 16 5.91 13.09 3 9.5 3S3 5.91 3 9.5 5.91 16 9.5 16c1.61 0 3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01 5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z" />
        </svg>
      <input class="nav-search-bar" type="text" placeholder="Find your Coop" v-model="searchQuery" />
      
      </div>
    </form> -->
    <nav class="navbar navbar-expand-md navbar-light fixed-top">
      <div class="container-fluid">
        <a href="http://localhost:8080/" class="navbar-brand"
          ><img alt="logo" src="../../public/images/logo.png"
        /></a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="navbarsExampleDefault"
          label="Toggle navigation"
          href
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        
        
        <div class="_collapse _navbar-collapse">
          <ul class="navbar-nav mr-auto">
            <li><drop-down-menu /></li>
            <li class="nav-item">
              <router-link class="nav-link" to="/register">Register</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/login"> Log in</router-link>
            </li>
            
          </ul>
        </div>
      </div>
    </nav>
    <!-- Nav above. Map Filter Below -->
    <div class="maps-wrapper">
      <map-filter id="spacer" />
      <!-- Map component  -->
      <div class="maps">
        <map-with-pins id="map"> </map-with-pins>
      </div>
    </div>
    
    <div class="footer-dark">
      <footer>
        <div class="footer-container">
          <div class="footer-section">
            <h3>Services</h3>
            <ul>
              <li><a href="#">Payment</a></li>
              <li><a href="#">Rentals</a></li>
              <li><a href="#">Privacy</a></li>
            </ul>
          </div>
          <div class="footer-section">
            <h3>About</h3>
            <ul>
              <li><a href="#">Blog</a></li>
              <li><a href="#">Team</a></li>
              <li><a href="#">Careers</a></li>
            </ul>
          </div>
          <div class="footer-section">
            <h3>Rent Roost</h3>
            <p>
              Praesent sed lobortis mi. Suspendisse vel placerat ligula. Vivamus
              ac sem lacus. Ut vehicula rhoncus elementum. Etiam quis tristique
              lectus. Aliquam in arcu eget velit pulvinar dictum vel in justo.
            </p>
            <div class="col item social">
              <a href="#"><i class="icon ion-social-facebook"></i></a
              ><a href="#"><i class="icon ion-social-twitter"></i></a
              ><a href="#"><i class="icon ion-social-snapchat"></i></a
              ><a href="#"><i class="icon ion-social-instagram"></i></a>
            </div>
          </div>
        </div>

        <div class="footer-container footer-container-bottom">
          <p class="copyright">Rent Roost © 2023</p>
          <p>
            Roost Coop is committed to ensuring digital accessibility for
            individuals with disabilities. We are continuously working to
            improve the accessibility of our web experience for everyone, and we
            welcome feedback and accommodation requests. If you wish to report
            an issue or seek an accommodation, please.
          </p>
        </div>

      </footer>
    </div>
  </div>
</template>

<script>
import DropDownMenu from '../components/DropDownMenu.vue';
import MapFilter from "../components/MapFilter.vue";
import MapWithPins from "../components/MapWithPins.vue";

export default {
  name: "home",
  components: {
    MapWithPins,
    MapFilter,
    DropDownMenu,
  },
};
</script>

<style scoped>
.maps-wrapper {
  width: 100%;
  display: flex;
  height: 90vh;
}

.footer-container {
  display: flex;
  width: 1080px;
  max-width: 100%;
  margin: 0 auto;
  padding-top: 5px;
}

.nav-item {
 
  

}

.footer-container-bottom {
  flex-direction: column;
  text-align: center;
  align-items: center;
}

.footer-container > * {
  flex-basis: 25%;
}
.footer-section:last-child {
  flex-grow: 2;
}
.footer-section ul li {
  display: block;
  text-align: left;
  margin: 10px 0;
}
#spacer {
  padding-top: 0px;
}

.home {
  display: flex;
  flex-direction: column;
  margin-top: 40px;
}

.navbar navbar-expand-md navbar-light fixed-top {
  display: flex;
  justify-content: end;
}

.navbar-collapse {
  width: 100%;
}

.navbar-brand {
  padding: 0;
  margin: 0;
}
.navbar-brand img {
  display: flex;
  justify-content: flex-start;
  height: 50px;
  width: 180px;
  padding-left: 0;
  margin: 0;
  left: 0;
  
}
.navbar-brand {
  text-transform: uppercase;
  color: red;
}

.navbar-light {
  display: flex;
  justify-content: flex-end;
  align-content: flex-end;
  align-items: baseline;
  align-content: stretch;
  background-color: #ffffff;
  box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
}

#map {
  /* adding rounded corners */
  border-radius: 20px;
  margin: 0 auto;
  -moz-border-radius: 20px;
  -webkit-mask-border-radius: 20px;
  -webkit-border-radius: 20px;
  -webkit-transform: translate3d(0px, 0px, 0px);
  -webkit-mask-image: -webkit-radial-gradient(#d3d3d3, #d3d3d3);
  height: 100%;
}

.maps {
  height: auto;
  width: 100%;
  /* here is where the background of the corners is */
  background-color: #f5f5f5;
  float: left;
  border-radius: 4px;
}

.light-grey-box {
  width: 30%;
  height: auto;
  background-color: #d3d3d3;
  float: right;
  padding: 20px;
}

ul {
  columns: 1;
  padding-left: 200px;
  line-height: 30px;
}

li {
  margin: 0 10px;
  display: inline-block;
  padding-top: 0;
  text-align: center;
}

.rectangular-box {
  width: 45%;
  height: 100px;
  background-color: white;
  display: inline-block;
  margin-right: 10px;
}

.price-scale-widget {
  width: 100%;
  height: 50px;
  background-color: white;
  clear: both;
  margin-top: 20px;
}

p {
  color: #ffffff;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-transform: none;
  font-family: "Fira Sans", sans-serif;
  font-weight: 400;
  font-size: 12px;
  line-height: 16px;
  margin: 0;
  padding-bottom: 5px;
  padding-top: 10px;
}

.commited {
  max-width: 720px;
  margin: auto;
  margin-bottom: 24px;
}

.lower {
  margin: auto;
  padding: 24px 0;
  color: rgb(160, 160, 160);
  text-align: center;
}

.footer-dark {
  padding: 100;
  color: #ffffff;
  width: 100%;
  background-color: #3a3a3a;
  bottom: 0;
}

.footer-dark h3 {
  margin-top: 0;
  padding-top: 10px;
  margin-bottom: 12px;
  font-weight: bold;
  font-size: 16px;
}

.footer-dark ul {
  padding: 5px;
  list-style: none;
  line-height: 1.6;
  font-size: 14px;
  margin-bottom: 0;
}

.footer-dark ul a {
  color: inherit;
  text-decoration: none;
  opacity: 0.6;
}

.footer-dark ul a:hover {
  opacity: 0.8;
}

@media (max-width: 767px) {
  .footer-dark .item:not(.social) {
    text-align: center;
    padding-bottom: 20px;
  }
}

.footer-dark .item.text {
  margin-bottom: 36px;
}

@media (max-width: 767px) {
  .footer-dark .item.text {
    margin-bottom: 0;
  }
}

.footer-dark .item.text p {
  opacity: 0.88;
  margin-bottom: 0;
}

.footer-dark .item.social {
  text-align: center;
  padding-top: 20px;
}

@media (max-width: 991px) {
  .footer-dark .item.social {
    text-align: center;
    margin-top: 20px;
  }
}

.footer-dark .item.social > a {
  font-size: 20px;
  width: 36px;
  height: 36px;
  line-height: 36px;
  display: inline-block;
  text-align: center;
  border-radius: 50%;
  box-shadow: 0 0 0 1px rgb(255, 255, 255);
  margin: 0 8px;
  color: #fff;
  opacity: 0.95;
}

.footer-dark .item.social > a:hover {
  opacity: 0.5;
}

.footer-dark .copyright {
  text-align: center;
  padding-top: 24px;
  opacity: 0.9;
  font-size: 13px;
  margin-bottom: 0;
  color: rgb(255, 45, 45);
  font-family: "Fira Sans", sans-serif;
  font-weight: 400;
}

@media only screen and (min-width: 768px) {
  .navbar-collapse,
  .navbar-expand-md,
  .collapse {
    display: unset !important;
  }
}



input[type="text"] {
  outline-color: tomato;
  
  background-color: rgba(255, 255, 255, 0);

}
input::placeholder {
  color: rgba(255, 54, 54, 0.442);
}

.search-btn{
  
  display: flex;
  max-width: 15px;
  justify-content: center;
  box-shadow: none;
  background-color: white;

}


form {
  display: flex;
  align-items: center;
  justify-content: flex-start;
  padding-top: 25px;
}
input {
  
    outline-color: none;
    background-color: transparent;
    border:none;
    width: 30%;
    flex-grow:1;
    font-size: 15px;
}

input:focus {
  outline: none;
}
.voice {
  height:20px;
  margin: 0px 5px;
}

.search-icon {
  color: red;
  margin: 0px 5px;
}
.wrapper {
    width: 24%;
    height: 100%;
    padding: 2px;
    border-radius: 10px;
    border: 1px solid #dcdcdc;
    outline-color: #FF00;
    cursor: text;
    background-color: transparent;
    display:flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
}

.wrapper:hover{
  box-shadow: 1px 1px 8px 1px #dcdcdc;
  outline-color: red;
}

input.nav-search-bar {
  width: 40%;
  margin-right:10px;

}
button.search-btn {
  display: flex;
  align-items: center;
  
}

svg {
  display: flex;
  width: 24px;
  height: 24px;
  margin-left: 5px;
  align-self: center;

}
</style>