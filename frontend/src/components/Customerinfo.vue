<template>

<v-data-table
    :headers="headers"
    :items="customerinfo"
    :items-per-page="5"
    class="elevation-1"
  ></v-data-table>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'Customerinfo',
    props: {
      value: Object,
      editMode: Boolean,
      isNew: Boolean
    },
    data: () => ({
        headers: [
            { text: "customerId", value: "customerId" },
            { text: "customerStatus", value: "customerStatus" },
            { text: "bankingStatus", value: "bankingStatus" },
            { text: "accountStatus", value: "accountStatus" },
            { text: "accountNo", value: "accountNo" },
            { text: "accountBal", value: "accountBal" },
        ],
        customerinfo : [],
    }),
    async created() {
      var temp = await axios.get(axios.backend + '/customerinfos')

      this.customerinfo = temp.data._embedded.customerinfos;

    },
    methods: {
    }
  }
</script>

