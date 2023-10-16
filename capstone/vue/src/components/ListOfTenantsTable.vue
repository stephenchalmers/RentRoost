<template>
  <table>
    <thead>
      <tr>
        <th>Name</th>
        <th>Phone</th>
        <th>Rent Payment</th>
        <th>Address</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="tenant in tenants" v-bind:key="tenant.tenantId">
        <td>{{ tenant.tenantName }}</td>
        <td>{{ tenant.tenantPhone }}</td>
        <td>${{ tenant.rent }}</td>
        <td>
          <template v-if="tenant.tenantAddress">
            {{ tenant.tenantAddress }}
          </template>
          <template v-else>
            <select>
              <option v-for="address in addresses" v-bind:key="address.id">{{ address }}</option>
            </select>
          </template>
        </td>
      </tr>
    </tbody>
  </table>
</template>
<script>
import propertyService from "../services/PropertyService";

export default {
  data() {
    return {
      tenants: [],
      addresses: [],
    };
  },
  methods: {
    fillTenantsTable() {
      propertyService
        .getPrincipalTenantsList()
        .then((response) => (this.tenants = response.data));
    },

    fillProperties() {
      propertyService
        .getPrincipalPropertyList()
        .then((response) => (this.addresses = response.data));
    },

    changeAddress(tenant) {
      tenant.tenantAddress = event.target.value;
    },
  },
  created() {
    this.fillTenantsTable();
    this.fillProperties();
  },
};
</script>
<style scoped>
table {
  width: 70%;
  text-align: left;
  border-collapse: collapse;
  box-shadow: rgba(0, 0, 0, 0.07) 0px 1px 3px 0px,
    rgba(27, 31, 35, 0.15) 0px 0px 0px 1px;
  font-size: 16px;
  background-color: #fafafa;
  border-radius: 3px;
  border-top: solid 10px #ff0000;
}

th {
  padding-top: 40px;
  padding: 10px;
  font-weight: bold;
  font-size: 18px;
  border-bottom: 1px solid #f2f2f2;
}

td {
  padding: 10px;
  border-bottom: 1px solid #f2f2f2;
}

td button {
  background-color: #ff0000;
  box-shadow: none;
  border-radius: 3px;
  color: white;
  font-weight: 300;
  margin-top: 0px;
  padding: 10px 0;
  outline: 0;
}

td button:hover {
  box-shadow: rgba(0, 0, 0, 0.02) 0px 1px 3px 0px,
    rgba(27, 31, 35, 0.15) 0px 0px 0px 1px;
}

select {
  background-color: #f5f5f5;
  border: none;
  box-shadow: none;
  border-radius: 3px;
  color: #000;
  font-weight: 300;
  margin: 0px;
  padding: 10px 0;
  outline: 0;
  width: 100%;
}
</style>