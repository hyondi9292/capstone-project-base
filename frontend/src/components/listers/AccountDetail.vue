<template>
    <v-card outlined>
        <v-card-title>
            Account # {{item._links.self.href.split("/")[item._links.self.href.split("/").length - 1]}}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="CustomerId" v-model="item.customerId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="AccountNo" v-model="item.accountNo" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="AccountBal" v-model="item.accountBal" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="AccountStatus" v-model="item.accountStatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="TrnsCode" v-model="item.trnsCode" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>
</template>


<script>
    const axios = require('axios').default;

    import String from '../primitives/String.vue';
    import Number from '../primitives/Number.vue';
    import Boolean from '../primitives/Boolean.vue';
    import Date from '../primitives/Date.vue';


    export default {
        name: 'AccountDetail',
        components:{
            String,
            Number,
            Boolean,
            Date,
        },
        props: {
        },
        data: () => ({
            item: null,
        }),
        async created() {
            var me = this;
            var params = this.$route.params;
            var temp = await axios.get(axios.fixUrl('/accounts/' + params.id))
            if(temp.data) {
                me.item = temp.data
            }
        },
        methods: {
        },
    };
</script>
