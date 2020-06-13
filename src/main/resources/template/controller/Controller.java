package ${package_controller};
import ${package_entity}.${Table};
import ${package_service}.${Table}Service;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
<#if swagger==true>import io.swagger.annotations.*;</#if>
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/****
 * @Author:xph
 * @Description:
 *****/
<#if swagger==true>@Api(value = "${Table}Controller")</#if>
@RestController
@RequestMapping("/${table}")
@CrossOrigin
public class ${Table}Controller {

    @Autowired
    private ${Table}Service ${table}Service;

    /***
     * ${Table}鍒嗛〉鏉′欢鎼滅储瀹炵幇
     * @param ${table}
     * @param page
     * @param size
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}鏉′欢鍒嗛〉鏌ヨ",notes = "鍒嗛〉鏉′欢鏌ヨ${Table}鏂规硶璇︽儏",tags = {"${Table}Controller"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "褰撳墠椤�", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "姣忛〉鏄剧ず鏉℃暟", required = true, dataType = "Integer")
    })
    </#if>
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) <#if swagger==true>@ApiParam(name = "${Table}瀵硅薄",value = "浼犲叆JSON鏁版嵁",required = false)</#if> ${Table} ${table}, @PathVariable  int page, @PathVariable  int size){
        //璋冪敤${Table}Service瀹炵幇鍒嗛〉鏉′欢鏌ヨ${Table}
        PageInfo<${Table}> pageInfo = ${table}Service.findPage(${table}, page, size);
        return new Result(true,StatusCode.OK,"鏌ヨ鎴愬姛",pageInfo);
    }

    /***
     * ${Table}鍒嗛〉鎼滅储瀹炵幇
     * @param page:褰撳墠椤�
     * @param size:姣忛〉鏄剧ず澶氬皯鏉�
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}鍒嗛〉鏌ヨ",notes = "鍒嗛〉鏌ヨ${Table}鏂规硶璇︽儏",tags = {"${Table}Controller"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "褰撳墠椤�", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "姣忛〉鏄剧ず鏉℃暟", required = true, dataType = "Integer")
    })
    </#if>
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //璋冪敤${Table}Service瀹炵幇鍒嗛〉鏌ヨ${Table}
        PageInfo<${Table}> pageInfo = ${table}Service.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"鏌ヨ鎴愬姛",pageInfo);
    }

    /***
     * 澶氭潯浠舵悳绱㈠搧鐗屾暟鎹�
     * @param ${table}
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}鏉′欢鏌ヨ",notes = "鏉′欢鏌ヨ${Table}鏂规硶璇︽儏",tags = {"${Table}Controller"})
    </#if>
    @PostMapping(value = "/search" )
    public Result<List<${Table}>> findList(@RequestBody(required = false) <#if swagger==true>@ApiParam(name = "${Table}瀵硅薄",value = "浼犲叆JSON鏁版嵁",required = false)</#if> ${Table} ${table}){
        //璋冪敤${Table}Service瀹炵幇鏉′欢鏌ヨ${Table}
        List<${Table}> list = ${table}Service.findList(${table});
        return new Result<List<${Table}>>(true,StatusCode.OK,"鏌ヨ鎴愬姛",list);
    }

    /***
     * 鏍规嵁ID鍒犻櫎鍝佺墝鏁版嵁
     * @param id
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}鏍规嵁ID鍒犻櫎",notes = "鏍规嵁ID鍒犻櫎${Table}鏂规硶璇︽儏",tags = {"${Table}Controller"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "涓婚敭ID", required = true, dataType = "${keyType}")
    </#if>
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable ${keyType} id){
        //璋冪敤${Table}Service瀹炵幇鏍规嵁涓婚敭鍒犻櫎
        ${table}Service.delete(id);
        return new Result(true,StatusCode.OK,"鍒犻櫎鎴愬姛");
    }

    /***
     * 淇敼${Table}鏁版嵁
     * @param ${table}
     * @param id
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}鏍规嵁ID淇敼",notes = "鏍规嵁ID淇敼${Table}鏂规硶璇︽儏",tags = {"${Table}Controller"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "涓婚敭ID", required = true, dataType = "${keyType}")
    </#if>
    @PutMapping(value="/{id}")
    public Result update(@RequestBody <#if swagger==true>@ApiParam(name = "${Table}瀵硅薄",value = "浼犲叆JSON鏁版嵁",required = false)</#if> ${Table} ${table},@PathVariable ${keyType} id){
        //璁剧疆涓婚敭鍊�
        ${table}.${keySetMethod}(id);
        //璋冪敤${Table}Service瀹炵幇淇敼${Table}
        ${table}Service.update(${table});
        return new Result(true,StatusCode.OK,"淇敼鎴愬姛");
    }

    /***
     * 鏂板${Table}鏁版嵁
     * @param ${table}
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}娣诲姞",notes = "娣诲姞${Table}鏂规硶璇︽儏",tags = {"${Table}Controller"})
    </#if>
    @PostMapping
    public Result add(@RequestBody  <#if swagger==true>@ApiParam(name = "${Table}瀵硅薄",value = "浼犲叆JSON鏁版嵁",required = true)</#if> ${Table} ${table}){
        //璋冪敤${Table}Service瀹炵幇娣诲姞${Table}
        ${table}Service.add(${table});
        return new Result(true,StatusCode.OK,"娣诲姞鎴愬姛");
    }

    /***
     * 鏍规嵁ID鏌ヨ${Table}鏁版嵁
     * @param id
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}鏍规嵁ID鏌ヨ",notes = "鏍规嵁ID鏌ヨ${Table}鏂规硶璇︽儏",tags = {"${Table}Controller"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "涓婚敭ID", required = true, dataType = "${keyType}")
    </#if>
    @GetMapping("/{id}")
    public Result<${Table}> findById(@PathVariable ${keyType} id){
        //璋冪敤${Table}Service瀹炵幇鏍规嵁涓婚敭鏌ヨ${Table}
        ${Table} ${table} = ${table}Service.findById(id);
        return new Result<${Table}>(true,StatusCode.OK,"鏌ヨ鎴愬姛",${table});
    }

    /***
     * 鏌ヨ${Table}鍏ㄩ儴鏁版嵁
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "鏌ヨ鎵�鏈�${Table}",notes = "鏌ヨ鎵�${Table}鏈夋柟娉曡鎯�",tags = {"${Table}Controller"})
    </#if>
    @GetMapping
    public Result<List<${Table}>> findAll(){
        //璋冪敤${Table}Service瀹炵幇鏌ヨ鎵�鏈�${Table}
        List<${Table}> list = ${table}Service.findAll();
        return new Result<List<${Table}>>(true, StatusCode.OK,"鏌ヨ鎴愬姛",list) ;
    }
}
