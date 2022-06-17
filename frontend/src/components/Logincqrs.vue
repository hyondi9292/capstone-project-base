<template>

<v-data-table
    :headers="headers"
    :items="logincqrs"
    :items-per-page="5"
    class="elevation-1"
  ></v-data-table>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'Logincqrs',
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
        logincqrs : [],
    }),
    async created() {
      var temp = await axios.get(axios.backend + '/logincqrs')

      this.logincqrs = temp.data._embedded.logincqrs;

    },
    methods: {
    }
  }
</script>

