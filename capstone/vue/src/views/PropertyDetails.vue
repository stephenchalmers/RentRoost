<template>
  <div class="main-container">
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
          
        ><a href="/user">Home page</a>
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="_collapse _navbar-collapse">
          <!-- ^^ class name changed...rename if needed -->
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
    <div class="container">
      <div class="left-side">
        <img :src="property.imageUrl" alt="Main Image" />
      </div>
      <div class="right-side">
        <div class="right-top-container">
          <h1>{{ property.propertyAddress }}</h1>
          <p>{{ property.propertyDescription }}</p>
          <div class="property-details">
            <h3>${{ property.propertyRent }}</h3>
            <h3>|</h3>
            <h3>Bed: {{ property.propertyBedrooms }}</h3>
            <h3>|</h3>
            <h3>Bath: {{ property.propertyBathrooms }}</h3>
          </div>
        </div>
        <div class="right-bottom-container">
          <button @click="toggleApplication()">Apply Now</button>
        </div>
      </div>
    </div>
    <br>
    <div class="form-container">
      <div class="application-form" v-if="showApplication">
      <form class="form-register" @submit.prevent="register">
        <h1 class="h3 mb-3 font-weight-normal">Rental Application</h1>
        <div class="alert alert-danger" role="alert" v-if="registrationErrors">
          {{ registrationErrorMsg }}
        </div>
        <label for="firstname" class="sr-only">First Name</label>
        <input
          type="text"
          id="firstname"
          class="form-control"
          placeholder="First Name"
          v-model="user.firstname"
          required
          style="margin-bottom: 10px"
          autofocus
        />
        <label for="lastname" class="sr-only">Last Name</label>
        <input
          type="text"
          id="lastname"
          class="form-control"
          placeholder="Last Name"
          v-model="user.lastname"
          required
          style="margin-bottom: 10px"
          autofocus
        />

        <label for="email" class="sr-only">Email</label>
        <input
          type="text"
          id="email"
          class="form-control"
          placeholder="Email"
          v-model="user.email"
          required
          style="margin-bottom: 10px"
          autofocus
        />
        <label for="phone" class="sr-only">Phone</label>
        <input
          type="text"
          id="phone"
          class="form-control"
          placeholder="Phone"
          v-model="user.phone"
          required
          style="margin-bottom: 10px"
          autofocus
        />
        
        <label for="username" class="sr-only">Move-In Date</label>
        <input
          type="date"
          id="username"
          class="form-control"
          placeholder="Move-In Date"
          v-model="user.username"
          required
          style="margin-bottom: 10px"
          autofocus
        />
        <button class="apply-button" @click="submitApplication()">Submit</button>
      </form>
      </div>
    </div>
    <center>
    <h2>Similar Properties</h2>
    <div class="container-similar">
      <div class="property-cards">
        <div v-for="prop in similarProperties" :key="prop.id">
          <img :src="prop.imageUrl" />
          <h3>{{ prop.propertyAddress }}</h3>
          <p>{{ prop.propertyDescription }}</p>
          <div class="details-similar">
            <h4>{{ prop.propertyRent }}</h4>
            <h4>Bed: {{ prop.propertyBedrooms }}</h4>
            <h4>Bath: {{ prop.propertyBathrooms }}</h4>
          </div>
        </div>
      </div>
    </div>
  </center>

    <properties-list-2 />
  </div>
</template>


<script>
import PropertiesList2 from "../components/PropertiesList2.vue";
import propertyService from "../services/PropertyService";
export default {
  components: { PropertiesList2 },

  name: "PropertyDetails",
  methods: {
    toggleApplication() {
      this.showApplication = !this.showApplication;
    },
    submitApplication() {
      this.showApplication = !this.showApplication;
      alert("Thank you! Your application was submitted. The property manager will reach out soon.")
    },
    getPropertyDetails() {
      let propertyId = this.$route.params.id;
      propertyService.getProperty(propertyId).then((response) => {
        this.property = response.data;
        console.log(this.property);
      });
    },
    fillArraySimProps() {
      async function getProperty(propertyId) {
        let property = await propertyService.getProperty(propertyId);
        return property.data;
      }

      for (let i = 0; i < 3; i++) {
        let propertyId = this.$route.params.id + i;
        getProperty(propertyId).then((property) => {
          this.similarProperties.push(property);
        });
      }
    },
  },
  data() {
    return {
      showApplication: false,
      user: {
        firstname: "",
        lastname: "",
        email: "",
        phone: "",
        username: "",
        password: "",
        confirmPassword: "",
        role: "",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
      property: {},
      similarProperties: [
        // ...
      ],
    };
  },
  created() {
    this.getPropertyDetails();
    this.fillArraySimProps();
  },
};
</script>


<style scoped>
.left-side img {
  scale: 100%;
}
div {
  border-radius: 3px;
}
.container {
  display: flex;
  widows: 100%;
  padding-top: 50px;
  justify-content: center;
  align-content: center;
}
.container-similar {
  display: flex;
  max-width: 1500px;
}

.left-side {
  min-width: 400px;
}

.application-form {
  background-color: #fafafa;
  width: 50%;
  padding: 100px;
  align-content: center;
}

.form-container {
  display: flex;
  align-content: center;
  justify-content: center;
  width: 100%;
}

.right-side {
  min-width: 600px;
  padding: 20px;
  background-color: #fafafa;
}
.right-bottom-container {
  display: flex;
  justify-content: flex-end;
  margin-top: 30px;
}

.property-details {
  display: flex;
  justify-content: space-between;
  margin-top: 20px;
}

.property-cards {
  display: flex;
  flex-wrap: wrap;
  margin-top: 20px;
}

.property-cards div {
  width: 30%;
  margin-right: 10px;
  padding: 20px;
  background-color: #eaeaea;
}

img {
  border-radius: 3px;
}
</style>
