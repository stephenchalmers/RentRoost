<template>
  <div class="map-filter-template">
    <div>
      <form id=search-form>
      <div class="wrapper">
          <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="#FF0000">
          <path d="M15.5 14h-.79l-.28-.27C15.41 12.59 16 11.11 16 9.5 16 5.91 13.09 3 9.5 3S3 5.91 3 9.5 5.91 16 9.5 16c1.61 0 3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01 5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z" />
        </svg>
      <input class="nav-search-bar" type="text" placeholder="Find your Coop" v-model="searchQuery" />
      
      </div>
    </form>
    </div>
    <div class="filters" id="filters">
      <form v-on:change.prevent="submitSearch">
        <div class="select-group">
          <label class="btn" for="bedrooms">Bedrooms: </label>
          <select id="bedrooms" v-model="searchForm.bedrooms">
            <option value="0" selected>Studio</option>
            <option value="1">1+</option>
            <option value="2">2+</option>
            <option value="3">3+</option>
          </select>
          <br />
          <label class="btn" for="bathrooms">Bathrooms: </label>
          <select id="bathrooms" v-model="searchForm.bathrooms">
            <option value="1" selected>1+</option>
            <option value="2">2+</option>
            <option value="3">3+</option>
          </select>
          
          <div class="rent-slider" data-min="500" data-max="10000">
            <div class="slider-container">
              <div class="value-container">
                <span id="demo">{{ sliderValue }}</span>
              </div>
            <label for="rent-range">Rent Maximum: </label>
            <input
              type="range"
              min="500"
              max="10000"
              value="1200"
              class="slider"
              id="rent-range"
              v-model="searchForm.maxRent"
              onchange="updateTextInput(this.value);"
            />
            </div>
          </div>
        
        </div>
      </form>
  </div>
    <div class="mini-property-list" id="mini-property-list">
      <sidebar-properties-list></sidebar-properties-list>
    </div>
  </div>
</template>

<script>
import propertyService from "../services/PropertyService";
import SidebarPropertiesList from "./SidebarPropertiesList.vue";

export default {
  components: {
    SidebarPropertiesList
  },
  data() {
    return {
      searchForm: {
        bedrooms: 0,
        bathrooms: 1,
        minRent: 0,
        maxRent: 10000,
        sliderValue: 0
      },
      message: "Hello from Vue component",
      name: "mapFilter",
      methods: {},
    };
  },
  methods: {
    submitSearch() {
      this.searchProperties(
        this.searchForm.bedrooms,
        this.searchForm.bathrooms,
        this.searchForm.minRent,
        this.searchForm.maxRent
      );
    },
    searchProperties(bedrooms, bathrooms, minRent, maxRent) {
      propertyService
        .searchProperties(bedrooms, bathrooms, minRent, maxRent)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_PROPERTIES", response.data);
          }
        })
        .catch((error) => {
          const response = error.response;
          if (response.status == 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
  computed: {
    sliderPercentage(){
      return (this.searchForm.maxRent - this.min) / (this.max - this.min) * 100;
    }
  }
};
</script>

<style scoped>
  .map-filter-template {
    display: flex;
    flex-direction: column;
  }

.slider::-webkit-slider-thumb{
  cursor: pointer;
  appearance: none;
  height: 35px;
  width: 35px;
  background-color: #ff0000;
  border-radius: 50%;
  border: 2px solid #fff;
  box-shadow: 2px 8px 13px -3px rgba(204, 204, 204, 0.685);
  -webkit-box-box-shadow: 2px 8px 13px -3px rgba(116, 114,114,0.75);
  -moz-box-shadow: 2px 8px 13px -3px rgba(216, 216, 216, 0.75);

}

.slider {
  width: 70%;
  background: linear-gradient(to right, #fc1100 0%, #ff3232 0%, rgba(255, 255, 255, 0.712));
  height: 20px;
  background: 450ms ease-in;
  -webkit-appearance: none;
  border-radius: 25px;
  box-shadow: 2px 8px 13px -3px rgba(196, 196, 196, 0.75);
  -webkit-box-box-shadow: 2px 8px 13px -3px rgba(216, 0, 0, 0.75);
  -moz-bozx-shadow: 2px 8px 13px -3px rgba(179, 179, 179, 0.75);
}

form {
  display: flex;
  justify-content: center;
  width: 80%;
}

.select-group {
  width: 300%px;
}

select {
  padding: 0 30px;
  width: 100%;
  height: 34px;
  border-radius: 6px;
  background-color: #f00;
  font-weight: 600;
  color: rgb(255, 255, 255);
}

body {
  padding: 0;
  height: 100%;
  margin: 0;
  width: 100%;
  background-color:transparent;
  display: flex;
  align-items: center;
  justify-content: center;
  
}
#demo{
  color: rgb(143, 134, 180);
  font-size: 15vh;
  font-family: sans,-serif;

}
.map-filter-template {
  width: 30%;
  height: inherit;
  /* min-height: calc("100vh - 50px"); */
  background-color: #f5f5f5;
  display: flex;
  justify-content: flex-start;
  align-items: center;
  overflow-y: scroll;
}

.slider-container {
  padding-top: -20px;
  display: flex;
  /* justify-content: flex-start; */
  width: 100%;
  align-items: center;
  margin: 20px 0;
  justify-content: center;
  border-radius: 8px;
  height: 65px;
}
.value-container {
  margin-bottom: 25px;

}

.container {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.btn {
  outline: 0;
  display: inline-flex;
  align-items: center;
  justify-content: space-between;
  background: transparent;
  /* min-width: 50%; */
  border: 0;
  border-radius: 6px;
  box-shadow: 0 4px 12px rgba(black, 0.1);
  box-sizing: border-box;
  padding: 15px 20px;
  color: rgb(0, 0, 0);
  font-size: 12px;
  font-weight: bold;
  letter-spacing: 1.2px;
  text-transform: uppercase;
  overflow: hidden;
  cursor: pointer;
}

.material-icons {
  border-radius: 100%;
  animation: ripple 0.6s linear infinite;
}

.bedrooms {
  position: absolute;
  top: 100%;
  left: 0;
  background: rgba(255, 255, 255, 0.096);
  width: 100%;
  border-radius: 4px;
  box-shadow: 0 4px 12px rgba(black, 0.1);
  text-align: left;
  opacity: 0;
  visibility: hidden;
  transition: 0.3s ease;
}

option {
  z-index: 1;
  position: relative;
  background: white;
  padding: 0 20px;
  color: #666;
}

/* TEST STUFF BELOW FOR SEARCH */

input[type="text"] {
  outline-color: tomato;
  
  background-color: rgba(255, 255, 255, 0);

}
input::placeholder {
  color: rgba(255, 54, 54, 0.442);
}

.search-btn{
  display: flex;
  /* max-width: 15px; */
  justify-content: center;
  box-shadow: none;
  background-color: white;

}


form {
  display: flex;
  align-items: center;
  justify-content: flex-start;
}
input {
    outline-color: none;
    background-color: transparent;
    border:none;
    width: 100%;
    flex-grow:1;
    font-size: 15px;
}

input:focus {
  outline: none;
}

.wrapper {
    width: 100%;
    height: 100%;
    padding: 2px;
    border-radius: 10px;
    border: 1px solid #dcdcdc;
    outline-color: #FF00;
    cursor: text;
    background-color: white;
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
  width: 100%;
  margin-right:10px;

}
button.search-btn {
  display: flex;
  align-items: center;
  
}
</style>