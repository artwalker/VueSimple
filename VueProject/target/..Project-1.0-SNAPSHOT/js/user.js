new Vue({
    el: "#app",
    data: {
        user: {
            is: '',
            username: '',
            password: '',
            email: '',
            age: '',
            sex: ''
        },
        userList: []
    },
    methods: {
        findAll: function () {
            var _this = this;
            axios.get(
                '/vue/user/findAll.do'
            )
                .then(function (response) {
                    _this.userList = response.data;//相应数据给userList赋值
                    console.log(response);
                })
                .catch(function (erroe) {
                    console.log(error);
                })
        },
        findById: function (userId) {
            var _this = this;
            axios.get('/vue/user/findById.do', {params:{id:userId}})
                .then(function (response) {
                    _this.user = response.data;
                    $("#myModal").modal("show");
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        updateUser: function (user) {//post请求
            var _this = this;
            axios.post('/vue/user/updateUser.do', _this.user)
                .then(function (response) {
                    _this.findAll();
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
    },
    created: function () {//当页面加载时触发请求来查询所有
        this.findAll();
    }
});