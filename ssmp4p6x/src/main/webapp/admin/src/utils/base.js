const base = {
    get() {
                return {
            url : "http://localhost:8080/ssmp4p6x/",
            name: "ssmp4p6x",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssmp4p6x/front/index.html'
        };
            },
    getProjectName(){
        return {
            projectName: "疫情防控物业管理系统"
        } 
    }
}
export default base
