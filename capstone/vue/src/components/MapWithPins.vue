<template>
  <div class="map">
    <!-- gmap tag pulls from node_modules.vue2-google-maps and creates a window @ the specified size -->
    <gmap-map
      :zoom="13"
      :center="center"
      style="width: 100%; height: inherit"
      :options="{ mapTypeControl: false, streetViewControl: false }"
    >
      <!-- info windows pop out when a user clicks on a map marker -->
      <gmap-info-window
        :options="infoOptions"
        :position="infoPosition"
        :opened="infoOpened"
        :content="infoContent"
        @closeclick="infoOpened = false"
      ></gmap-info-window>
      <!-- place map markers for each marker object in the store -->
      <gmap-cluster :zoomOnClick="true">
        <gmap-marker
          :key="index"
          v-for="(m, index) in $store.state.propertiesList"
          :position="m.propertyPosition"
          :clickable="true"
          :draggable:="false"
          @click="toggleInfo(m, index)"
          :icon="{
            url: 'https://img.icons8.com/emoji/256/red-circle-emoji.png',
            scaledSize: { width: 20, height: 20 },
          }"
        ></gmap-marker>
      </gmap-cluster>
    </gmap-map>
  </div>
</template>

<script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.5.0/vue.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/markerclustererplus/2.1.4/markerclusterer.js"></script>
<script src="vue-google-maps.js"></script>
   
<script>
import propertyService from "../services/PropertyService";

export default {
  name: "MapWithPins",
  data() {
    return {
      center: {
        lat: 40.44104,
        lng: -80.00221,
      },
      // infobox values
      infoPosition: null,
      infoContent: null,
      infoOpened: false,
      infoCurrentKey: null,

      infoOptions: {
        pixelOffset: {
          width: 0,
          height: -35,
        },
        content: "null content error",
        infoRent: null,
        infoBedrooms: null,
      },
    };
  },
  created() {
    propertyService
      .getAllProperties()
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
  methods: {
    // toggle property marker location based on click and set its values
    toggleInfo(marker, index) {
      this.infoPosition = marker.propertyPosition;
      // this.infoOptions.content = marker.infoText;
      const contentString = `<div class="info-window">
        <div id="info"><b>Rent:</b> $${marker.propertyRent}<br><b>Bedrooms: </b>${marker.propertyBedrooms}</div>
        <div id="image"><img src="${marker.imageUrl}" alt="Image Not Available" width="150px"></div>
        <div></div>
        <div id="posting-link"><a href="PropertyDetails/${marker.propertyId}">More Details...</a></div>
        </div>
        <style scoped>
          .info-window {
            display: grid;
            grid-template-columns: 1fr 2fr;
            grid-template-areas: 
              "image info"
              "image posting-link";
            gap: 10px;
            }
          #info {
            text-align: left;
          }
          #posting-link {
            text-align: right;
          }
          #image {
          }
          #image > img {
            width:125px;
          }
          </style>`;
      this.infoOptions.content = contentString;

      if (this.currentKey === index) {
        this.infoOpened = !this.infoOpened;
      } else {
        this.infoOpened = true;
        this.currentKey = index;
      }
    },
  },
};
</script>
