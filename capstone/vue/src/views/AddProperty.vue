<template>
  <div id="add-property">
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
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        
        
        <div class="_collapse _navbar-collapse">
          <ul class="navbar-nav mr-auto">
            <li><drop-down-menu /></li>
            <li class="nav-item">
              <router-link class="nav-link" to="/account">Account</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/logout"> Log out</router-link>
            </li>
            
          </ul>
        </div>
      </div>
    </nav>
    <!--  -->


        <h1>Your Properties</h1>
      <div>
        <CloudinaryComp />
            
              <add-property-form-page />
      </div>
    <properties-list />  </div>
</template>

<script>
import PropertiesList from "../components/PropertiesList.vue";
import AddPropertyFormPage from '../views/AddPropertyFormPage.vue';

export default {
  components: { PropertiesList, AddPropertyFormPage },
  name: "addproperty",

  // Needs Methods for Adding properties

data(){
  return{
    newProp: {
      title: "",
      body: "",
      img_url: ""
    },
    
  }
},


methods: {
  uploadImage() {
    this.imageWidget.open()
  },

// submitPost() {
//   PostsService.createPost(this.newPost).then(response) => {
//     if (response.status === 201) {
//       this.$router.push{

//       }
//     }
//   }
// }


},

};
</script>

<style scoped>
#add-property {
  display: flex;
  flex-direction: column;
  justify-content: center;
  
}

button {
    background-color: #ff0000;
  box-shadow: none;
  border-radius: 3px;
  color: white;
  font-weight: 300;
  margin-top: -20px;
  padding: 10px 0;
  outline: 0;
    height: 10%;
}
</style>