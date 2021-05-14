<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8"/>
    <title>一点课堂</title>
</head>
<body>
${name}
<#if address=="1"> 上海
    <#elseif address=="2"> 北京
    <#else>广州
</#if>
<#list listResult as res>
    ${res}
</#list>
</body>
</html>