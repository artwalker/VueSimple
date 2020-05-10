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
            var _this = this;//定义this为vue对象，如果在axios中定义则是axios对象
            axios.get(
                '/vue/user/findAll.do'
            )
                .then(function (response) {//需要在controller里加上@ResponseBody,直接加在类上就不用在每个需要加的方法上加了
                    _this.userList = response.data;//响应数据给userList(上边定义了userList)赋值
                    console.log(response);
                })
                .catch(function (erroe) {
                    console.log(error);
                })
        },
        findById: function (userId) {
            var _this = this;//定义this为vue对象，如果在axios中定义则是axios对象
            axios.get('/vue/user/findById.do', {params:{id:userId}})
                .then(function (response) {//需要在controller里加上@ResponseBody,直接加在类上就不用在每个需要加的方法上加了
                    _this.user = response.data;//响应数据给user(上边定义了user)
                    $("#myModal").modal("show");//开启编辑修改功能
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        updateUser: function (user) {//post请求
            var _this = this;//定义this为vue对象，如果在axios中定义则是axios对象
            axios.post('/vue/user/updateUser.do', _this.user)//需要在controller里的updataUser的参数类型前加上@RequsetBody
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