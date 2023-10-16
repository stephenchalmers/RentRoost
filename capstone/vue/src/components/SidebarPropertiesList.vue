 <template>
    <div>
      <mini-property-card  v-bind:property="property" v-for="property in $store.state.propertiesList" v-bind:key="property.id" />
    </div>
</template>

<script>
import MiniPropertyCard from './MiniPropertyCard.vue';
import propertyService from "../services/PropertyService";

export default {
  components: {MiniPropertyCard},
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
  flex-direction: column;
  flex-wrap: wrap;
  justify-content: flex-start;
}
</style>
 