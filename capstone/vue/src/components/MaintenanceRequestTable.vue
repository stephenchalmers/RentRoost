<template>
  <div>
    <table>
      <thead>
        <tr>
          <th>Tenant Name</th>
          <th>Description</th>
          <th>Address</th>
          <th>Status</th>
          <th>Assigned To</th>
          <th>Assign</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="request in showAllRequests ? requests : requests.slice(0, 5)" v-bind:key="request.id">
          <td>{{ request.tenantName }}</td>
          <td>{{ request.maintenanceRequest }}</td>
          <td>{{ request.propertyAddress }}</td>
          <td>{{ request.repairStatus }}</td>
          <td>{{ request.assignedEmployee }}</td>
          <td>
            <select
              v-model="request.assignedEmployee"
              @change="onSelectionChange(request)"
            >
              <option
                v-for="employee in employees"
                :value="employee"
                v-bind:key="employee.employeeId"
              >
                {{ employee.employeeId }} - {{employee.employeeName}}
              </option>
            </select>
            <span v-if="request.assignedEmployee">
              {{ request.assignedEmployee.employeeId }} - {{ request.assignedEmployee.employeeName }}
            </span>
          </td>
        </tr>
      </tbody>
    </table>
    <button @click="showAllRequests = !showAllRequests">{{ showAllRequests ? 'Close Table' : 'Open Table' }}</button>
  </div>
</template>
<script>
import propertyService from "../services/PropertyService";
export default {
  data() {
    return {
      requests: [],
      employees: [
      ],
      showAllRequests: false,
    };
  },
  methods: {
    onSelectionChange(request) {
      request.isAssigning = false;
      let maintenanceId = request.maintenanceId;
      let employeeId = request.assignedEmployee.employeeId;
      propertyService.assignEmployeeToRequest(maintenanceId, employeeId).then((response) => {
        console.log(response);
      });
    },
    fillMaintenanceRequestList() {
      propertyService.getPrincipalMaintenanceList().then((response) => (this.requests = response.data))
    },
    getAllEmployees() {
      propertyService.getAllEmployees().then((response) => (this.employees = response.data))
    }
  },
  created() {
    this.fillMaintenanceRequestList()
    this.getAllEmployees()
  }
};
</script>

<style scoped>

table {
  width: 100%;
  text-align: left;
  border-collapse: collapse;
  box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px;
  
   
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