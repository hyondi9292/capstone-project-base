<template>
    <div>
        <v-list two-line v-if="list.length > 0">
            <v-list-item-group 
                    v-model="selected" 
                    color="indigo"
                    @change="select"
            >
                <v-list-item v-for="(item, idx) in list" :key="idx">
                    <template v-slot:default="{ active }">
                        <v-list-item-avatar color="grey darken-1"></v-list-item-avatar>
                    
                        <v-list-item-content>
                            <v-list-item-title>
                                {{idx+1 }}
                            </v-list-item-title>
                            <v-list-item-subtitle>
                                CustomerId :  {{item.customerId }} * 
                                BankingId :  {{item.bankingId }} * 
                                Password :  {{item.password }} * 
                                Status :  {{item.status }} * 
                            </v-list-item-subtitle>
                        </v-list-item-content>

                        <v-list-item-action>
                            <v-checkbox :input-value="active" color="indigo"></v-checkbox>
                        </v-list-item-action>
                    </template>
                </v-list-item>
            </v-list-item-group>
        </v-list>
    </div>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'SmartbankingPicker',
        props: {
            value: [String, Object, Array, Number, Boolean],
        },
        data: () => ({
            list: [],
            selected: null,
        }),
        async created() {
            var me = this;
            var temp = await axios.get(axios.fixUrl('/smartbankings'))
            if(temp.data) {
                me.list = temp.data._embedded.smartbankings;
            }

            if(me.value && typeof me.value == "object") {
                var id = Object.values(me.value)[0];
                temp = await axios.get(axios.fixUrl('/smartbankings/' + id))
                if(temp.data) {
                    var val = temp.data
                    me.list.forEach(function(item, idx) {
                        if(item.name == val.name) {
                            me.selected = idx
                        }
                    })
                }
            }
        },
        methods: {
            select(val) {
                var obj = {}
                if(val != undefined) {
                    obj['customerId'] = val; 
                    
                    
                    
                    
                    
                    
                    

                    var arr = this.list[val]._links.self.href.split('/');
                    this.$emit('selected', arr[4]);
                }
            },
        },
    };
</script>


