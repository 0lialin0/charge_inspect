package cn.wtkj.charge_inspect.data.net;

import java.util.Map;



import cn.wtkj.charge_inspect.data.bean.ArticleDetail;
import cn.wtkj.charge_inspect.data.bean.ArticleListData;

import cn.wtkj.charge_inspect.data.bean.BlackListData;
import cn.wtkj.charge_inspect.data.bean.ConstAllData;
import cn.wtkj.charge_inspect.data.bean.ContactListData;
import cn.wtkj.charge_inspect.data.bean.JCBlackListData;
import cn.wtkj.charge_inspect.data.bean.LoginRespone;
import cn.wtkj.charge_inspect.data.bean.NameRollXiafaData;
import cn.wtkj.charge_inspect.data.bean.OutListData;
import cn.wtkj.charge_inspect.data.bean.OutListInfoData;
import cn.wtkj.charge_inspect.data.bean.ViewOrganizationData;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;
import retrofit.http.QueryMap;

public interface DangerousApi {

    static final String END_POINT = "http://192.162.123.39:8080";// 收费稽查测试服务地
    //static final String END_POINT = "http://220.178.67.242:8554/appws";//收费稽查线上地址


    //带密码的登陆接口  OK
    @GET("/restApi?businessId=pass.check")
    void login2(@Query("USERID") String user,
               @Query("PASSWORD") String pwd,
               Callback<ResponeData> callback);

    //带密码的登陆接口  OK
    @POST("/restApi?businessId=pass.check")
    void login(@QueryMap Map<String, String> map,Callback<LoginRespone> callback);

    //获取基础数据  OK
    @POST("/restApi?businessId=const.all")
    void getConstAll(Callback<ConstAllData> callback);

    //获取基础数据  OK
    @POST("/restApi?businessId=const.organization")
    void getOrgan(@QueryMap Map<String, String> map,Callback<ViewOrganizationData> callback);

    //获取业务联系单  OK
    @POST("/restApi?businessId=article.articleList&USERID=admin")
    void getBusinessData(@QueryMap Map<String, Integer> map,Callback<ArticleListData> callback);

    //获取业务联系单详情
    @POST("/restApi?businessId=article.articleInfo")
    void getBusinessDetail(@Query("ARTICLEID") String articleId,Callback<ArticleDetail> callback);

    //获取业务联系单  OK
    @POST("/restApi?businessId=daily.contact")
    void getContactList(Callback<ContactListData> callback);

    //增收上传  OK
    @POST("/restApi?businessId=stopLoop.stopLoopAct")
    void sendIncrement(@QueryMap Map<String, String> map,Callback<ResponeData> callback);

    //下发名单查询  OK
    @POST("/restApi?businessId=sendLsit.sendList")
    void selNameXiafa(@QueryMap Map<String, String> map,Callback<NameRollXiafaData> callback);

    //黑名单处理  OK
    @POST("/restApi?businessId=black.blackSolve")
    void sendXiafaHandle(@QueryMap Map<String, String> map,Callback<ResponeData> callback);

    //下发名单详情---黑名单  OK
    @POST("/restApi?businessId=black.blackInfo")
    void getBlackInfo(@QueryMap Map<String, String> map,Callback<BlackListData> callback);

    //下发名单详情---灰名单  OK
    @POST("/restApi?businessId=gray.grayInfo")
    void getGrayInfo(@QueryMap Map<String, String> map,Callback<BlackListData> callback);

    //下发名单详情---黄名单  OK
    @POST("/restApi?businessId=yellow.yellowInfo")
    void getYellowInfo(@QueryMap Map<String, String> map,Callback<BlackListData> callback);

    //流水查询  OK
    @POST("/restApi?businessId=outList.outListList")
    void outListSel(@QueryMap Map<String, String> map,Callback<OutListData> callback);

    //流水查询详情  OK
    @POST("/restApi?businessId=outList.outListInfo")
    void outListSelInfo(@QueryMap Map<String, String> map,Callback<OutListInfoData> callback);
}
