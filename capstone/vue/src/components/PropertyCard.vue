<template>
  <div class="property-card">
    <!-- DISPLAY MODE -->
    <img v-bind:src="property.imageUrl" />
    <h3 v-if="!editMode">{{ property.propertyName }}</h3>
    <h5 v-if="!editMode">{{ property.propertyAddress }}</h5>
    <h5 v-if="!editMode">
      ${{ property.propertyRent }} | Beds: {{ property.propertyBedrooms }} | Baths: {{ property.propertyBathrooms }}
    </h5>
    <h5 class="propDescription" v-if="!editMode">{{ property.propertyDescription }}</h5>
    <button v-if="!editMode" v-on:click="editProperty">Edit Property</button>
    <!-- EDIT MODE -->
    <label v-if="editMode">Name: </label><input type="text" v-model="tempProperty.propertyName" v-if="editMode" />
    <label v-if="editMode">Address: </label><input type="text" v-model="tempProperty.propertyAddress" v-if="editMode" />
    <label v-if="editMode">Price: </label><input type="text" v-model="tempProperty.propertyRent" v-if="editMode" />
    <label v-if="editMode">Bedrooms: </label><input type="text" v-model="tempProperty.propertyBedrooms" v-if="editMode" />
    <label v-if="editMode">Bathrooms: </label><input type="text" v-model="tempProperty.propertyBathrooms" v-if="editMode" />
    <label v-if="editMode">Description: </label><textarea v-model="tempProperty.propertyDescription" v-if="editMode"></textarea>
    <button v-if="editMode" @click="updateProperty()">Done</button>
    <button id="cancel-button" v-if="editMode" @click="cancelEdit()">Cancel</button>
  </div>
</template>
<script>
import propertyService from "../services/PropertyService";

export default {
  data() {
    return {
      name: "propertyCard",
      editMode: false,
      tempProperty: { ...this.property },
      editCache: {}
    }
  },
  methods: {
    updateProperty() {
      this.editMode = false;
      this.$emit("update-property", this.tempProperty);

      propertyService
      .updateProperty(this.tempProperty.propertyId, this.tempProperty)
      .then((response) => {
          if (response === 201) {
            console.log("success");
          }
        })
        .catch((error) => {
          const response = error.response;
          if (response.status == 401) {
            this.invalidCredentials = true;
          }
        });
    },
    editProperty() {
      console.log("edit property clicked");
      // take all property details and add to edit cache
      this.editCache.propertyName = this.tempProperty.propertyName;
      this.editCache.propertyAddress = this.tempProperty.propertyAddress;
      this.editCache.propertyRent = this.tempProperty.propertyRent;
      this.editCache.propertyBedrooms = this.tempProperty.propertyBedrooms;
      this.editCache.propertyBathrooms = this.tempProperty.propertyBathrooms;
      this.editCache.propertyDescription = this.tempProperty.propertyDescription;
      console.log("edit cache:")
      console.log(this.editCache);
      console.log("temp property:")
      console.log(this.tempProperty);
      this.editMode = true;
    },
    cancelEdit() {
      this.editCache = {};
      this.editMode = false;
    }
  },
  props: {
    property: Object,
  }
};
</script>
<style scoped>
img {
  width: 100%;
  height: 20vh;
  object-fit: cover;
  border-radius: 3px;
}

h3 {
  margin-top: 4px;
}
h5 {
  margin-top: -35px;
}
.property-card {
  font-family: Verdana, Geneva, Tahoma, sans-serif;
  background-color: #fafafa;
  margin: 30px;
  width: 25%;

  border-radius: 3px;
  display: flex;
  flex-direction: column;
  align-items: center;
  box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px;
  padding-bottom: 30px;
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
}

#cancel-button {
  background-color: white;
  color: #ff0000;
  border-color: black;
  border-radius: 10px;
  font-weight: 300;
  margin-top: -20px;
  padding: 10px 0;
  outline: 10px;
}

.propDescription {
  font-weight: 200;
  max-height: 120px;
  overflow: hidden;
  max-width: 75%;
  text-align: center;
}
</style>