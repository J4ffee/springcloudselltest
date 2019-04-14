<html>
<head>
    <title>订单详情</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-6 column">
            <table class="table">
                <thead>
                <tr>
                    <th>
                        订单id
                    </th>
                    <th>
                        订单总金额
                    </th>

                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        ${orderMaster.orderId}
                    </td>
                    <td>
                        ${orderMaster.orderAmount}
                    </td>

                </tr>
                </tbody>
            </table>
        </div>
        <div class="col-md-12 column">
            <table class="table">
                <thead>
                <tr>
                    <th>
                        商品id
                    </th>
                    <th>
                        商品名称
                    </th>
                    <th>
                        价格
                    </th>
                    <th>
                        数量
                    </th>
                    <th>
                        总额
                    </th>
                </tr>
                </thead>
                <tbody>
                <#list details as d>
                    <tr class="success">
                        <td>
                            ${d.detailId}
                        </td>
                        <td>
                            ${d.productName}
                        </td>
                        <td>
                            ${d.productPrice}
                        </td>
                        <td>
                            ${d.productQuantity}
                        </td>
                        <td>
                            ${orderMaster.orderAmount}
                        </td>
                    </tr>
                </#list>


                </tbody>
            </table>
        </div>
        <#if orderMaster.orderStatus==0>
        <div class="row clearfix">
            <div class="col-md-4 column">
                <a href="/sell/seller/order/finish?orderId=${orderMaster.orderId}&page=${currentPage}" type="button" class="btn btn-default btn-primary">完结订单</a>
                <a href="/sell/seller/order/cancel?orderId=${orderMaster.orderId}&page=${currentPage}" type="button" class="btn btn-default btn-danger">取消订单</a>
            </div>
            <div class="col-md-8 column">

            </div>
        </div>
        </#if>
    </div>
</html>