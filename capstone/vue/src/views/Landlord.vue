<template>

 <div class="landlord">

   <div class="tenant">
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
    <!-- Nav Bar Above -->
<div id="box">
  <div id="box2">
  </div>
    <maintenance-request-table id="MT" />
    <list-of-tenants-table id="LTT" />
  
 <!-- <form>
    
    <button type="submit">Submit</button>
    
  </form> -->
</div>
 </div>
 </div>
</template>

<script>

import ListOfTenantsTable from "../components/ListOfTenantsTable.vue";
import MaintenanceRequestTable from "../components/MaintenanceRequestTable.vue";
export default {
  components: { MaintenanceRequestTable, ListOfTenantsTable },
  name: "landlord",
  data() {
    return {
      description: "",
      imageUrl: "",
    };
  },
  methods: {
    
    
    //  removed AWS upload -Dez     
    
  },
};
</script>

<style>
.navbar-light {
  display: flex;
  flex-direction: column;
  flex-wrap: nowrap;
  justify-content: flex-end;
  align-items: baseline;
  align-content: stretch;
  border-bottom: 2px solid transparent;

  background-color: #ffffff;
box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px;
}



#LTT{
  box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px;
}
#box2{
  padding: 5 5 5 5;
}

#box{
  padding-top: 100px;
  
  
}
</style>
