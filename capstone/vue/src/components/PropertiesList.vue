 <template>
    <div>
      <property-card  v-bind:property="property" v-for="property in $store.state.myPropertiesList" v-bind:key="property.id" />
    </div>
</template>

<script>
import PropertyCard from './PropertyCard.vue';
import propertyService from "../services/PropertyService";

export default {
  components: {PropertyCard},
  name: "propertyList",
  created() {
    propertyService.getMyProperties().then((response) => {
        if (response.status == 200) {
          this.$store.commit("SET_MY_PROPERTIES", response.data)
        }
      }).catch((error) => {
        const response = error.response;
        if (response.status == 401) {
          this.invalidCredentials = true;
        }
      });
  }
};
</script>

<style scoped>
div {
  display: flex;
  flex-wrap: wrap;
  gap: 2em;
  justify-content: center;
}
</style>
 