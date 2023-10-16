import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'
import * as VueGoogleMaps from "vue2-google-maps" // Google Maps package
import GmapCluster from 'vue2-google-maps/dist/components/cluster'
import faker from "vue-faker"

require('dotenv').config()
Vue.config.productionTip = false

axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;

Vue.component('GmapCluster', GmapCluster);
Vue.use(VueGoogleMaps, {
  load: {
    key: process.env.VUE_APP_GMAPSAPIKEY,
    libraries: "places"
  }
});

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app');

////Liked image code below ////
const initApp = async () => {

  //get json data from db
  const contacts = await getDataFromDB();

  //render data to page
  renderContacts(contacts);
  // add listeners 
listenForLikes();

};

document.addEventListener("DOMContentLoaded", initApp);

const getDataFromDB = async () => {
  const fakeDataStream = await fetch(
    "https://fakerapi.it/api/v1/persons?_quantity=50"
  );
  const jsonData = await fakeDataStream.json();
  return jsonData.data;
};

const renderContacts = (contacts) => {
  const main = document.querySelector("main");
  const cardsArray = [];


  contacts.forEach((contact) => {
    const elemObj = createCardElements();
    const card = createPersonCard(elemObj, contact);
    cardsArray.push(card);
    // card elements
    // person card
    //push each card to the empty array

  });

  cardsArray.forEach(card => {
    main.appendChild(card);
  });

};

const createCardElements = () => {
  const article = document.createElement("article");
  const img = document.createElement("img");
  const details = document.createElement("div");
  const like = document.createElement("h2");
  const email = document.createElement("p");
  return { article, img, details, like, name, email };
};

const createPersonCard = (elemObj, person) => {
  const { article, img, details, like, name, email } = elemObj;

  details.className = "details";
  like.classlist.add("like", "like-no");

  name.textContent = `${person.firstname} ${person.lastname}`;
 img.src = faker.random.image(); //random person.image;
  img.src = person.image;
  email.textContent = person.email;

  article.appendChild(img);
  details.appendChild(name);
  details.appendChild(email);
  article.appendChild(details);
  article.appendChild(like);
  return article;
};

const listenForLikes = () => {
  const likes = document.querySelectorAll(".like");
  likes.forEach(like => {
    like.addEventListener("click", (event) => {
      event.target.classList.toggle("like-no");
      event.target.classList.toggle("like-yes");
      if (event.target.classList.contains("like-yes")) {
        console.log(" Saving Favorite")
        getFaveData(event.target);
      } else {
        console.log(" Removing Favorite");
        getFaveData(event.target);
      }
    })
  })
}

// data for adding/removing likes //
const getFaveData = (elem) => {
  const parent = elem.parentElement;
  const img = parent.querySelector("img").src;
  const name = parent.querySelector("h2").textContent;
  const email = parent.querySelector("p").textContent;
  const [firstname, lastname] = name.split(" ");
  const faveObj = { img, firstname, lastname, email }
    
  console.log(faveObj);


}