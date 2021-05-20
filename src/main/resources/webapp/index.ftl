<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title><#if article.title??>${article.title}</#if> | 代码笔记</title>
    <meta name="author" content="">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
    <link rel="alternate" href="../../atom.xml" title="Sanonz" type="application/atom+xml">
    <link rel="icon" href="../../images/favicon.ico">
    <base href="/">
    <style type="text/css">@font-face {
            font-family: icomoon;
            src: url(../../fonts/icomoon%EF%B9%96q628ml.eot);
            src: url(../../fonts/icomoon%EF%B9%96q628ml.eot#iefix) format('embedded-opentype'), url(../../fonts/icomoon%EF%B9%96q628ml.ttf) format('truetype'), url(../../fonts/icomoon%EF%B9%96q628ml.woff) format('woff'), url(../../fonts/icomoon%EF%B9%96q628ml.svg#icomoon) format('svg');
            font-weight: 400;
            font-style: normal
        }</style>
    <link rel="stylesheet" href="src/style.css">
    <link rel="stylesheet" href="css/prism.css">

    <!--[if lt IE 9]>
    <style type="text/css">.nav-inner {
        top: 0;
    }

    .author-meta {
        position: static;
        top: 0;
    }

    .search-form {
        height: 36px;
    }

    .token a {
        color: inherit;
    }
    </style>
    <script type="text/javascript" src="https://unpkg.com/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <![endif]-->
</head>
<body>
<main class="app">
    <header id="header" class="header clearfix">
        <div id="nav" class="nav">
            <div class="nav-mobile">
                <button id="open-panel" class="open-panel nav-mobile-item"><i class="icon-documents"></i></button>
                <h1 class="nav-mobile-title nav-mobile-item">Sanonz</h1>
                <button id="open-menus" class="open-panel nav-mobile-item"><i class="icon-library"></i></button>
            </div>
            <nav id="nav-inner" class="nav-inner">
                <#list catVoList as cat>
                    <#if cat.uuid == article.articleSource.rid>
                        <a class="nav-item active" onclick="catClick(${cat.uuid?c})" href="javascript:0;"
                           data-rid="${article.articleSource.uuid?c}"><span class="nav-text">${cat.name}</span> </a>
                    <#else>
                        <a class="nav-item " onclick="catClick(${cat.uuid?c})" href="javascript:0;"
                           data-rid="${article.articleSource.uuid?c}"><span class="nav-text">${cat.name}</span> </a>
                    </#if>
                </#list>
            </nav>
        </div>
        <aside id="aside" class="aside">
            <div id="aside-mask" class="aside-mask"></div>
            <div id="aside-inner" class="aside-inner">
                <form action="https://google.com/search" method="get" accept-charset="UTF-8" class="search-form">
                    <input type="search" name="q" class="search-form-input" placeholder="Search">
                    <button type="submit" class="search-form-submit"><i class="icon-search-stroke"></i></button>
                    <input type="hidden" name="sitesearch" value="https://sanonz.github.io"></form>
                <ol id="catlist" class="toc">
                    <#list articleVoList as item>

                        <#if item.articleSource.uuid?c == article.articleSource.uuid?c>
                            <li class="toc-item toc-level-2 active"><a class="toc-link"
                                                                       href="/post/${item.articleSource.uuid?c}">
                                    <span data-rid="${item.articleSource.rid?c}" data-aid="${item.articleSource.uuid?c}"
                                          class="toc-text"> ${item.title}</span></a>
                            </li>
                        <#else>
                            <li class="toc-item toc-level-2"><a class="toc-link"
                                                                href="/post/${item.articleSource.uuid?c}">
                                    <span class="toc-text"> ${item.title}</span></a>
                            </li>
                        </#if>
                    </#list>
                </ol>
            </div>
        </aside>
    </header>
    <div id="content" class="content">
        <div id="wrapper" class="wrapper">
            <article class="article" itemscope itemprop="blogPost">
                <header class="article-header"><h1 itemprop="name">  <#if article.title??>${article.title}</#if></h1>
                    <div class="article-meta clearfix">
                        <a class="article-date" href="index.html"><i
                                    class="icon-calendar vm"></i>
                            <time class="vm" datetime="${article.articleSource.dateadd}"
                                  itemprop="datePublished"><#if article.title??>${article.articleSource.dateadd}</#if></time>
                        </a>
                        <div class="article-tag-list">
                            <#list article.tags as tag>
                                <i class="icon-tag vm"></i>
                                <a class="article-tag-link"
                                   href="../../tags/CI/index.html"
                                   rel="tag">${tag.name}</a>
                            </#list>
                        </div>
                    </div>
                </header>
                <section class="article-body markdown-body">
                    <#if article.content??>${article.content}</#if>
                </section>
            </article>
        </div>
    </div>
    <footer class="footer">代码笔记由 <a href="https://github.com/MingCaiXiong/spring-boot-blog"
                                    target="_blank">spring-boot + MWeb + SQlite</a>技术构建 ,部署在 <a
                href="https://github.com/sanonz/hexo-theme-concise" target="_blank">hostdare主机商服务器</a>
        <script>
            var _hmt = _hmt || [];
            (function () {
                var hm = document.createElement("script");
                hm.src = "https://hm.baidu.com/hm.js?dccbfa33e03652ccd3b526590fc8dbe3";
                var s = document.getElementsByTagName("script")[0];
                s.parentNode.insertBefore(hm, s);
            })();
        </script>
    </footer>
</main>
<script src="/webjars/jquery/2.1.1/jquery.js"></script>
<script>

    function catClick(rid) {
        var settings = {
            "url": "/cats/" + rid,
            "method": "GET",
        };

        $.ajax(settings).done(function (response) {
            console.log(response);
            var data = response.data;

            var templates = '';
            for (var i = 0; i < data.length; i++) {
                (function (t) {
                    const item = data[t];
                    templates += '<li class="toc-item toc-level-2">' +
                        '<a class="toc-link" href="/post/' + item.articleSource.uuid
                        + '"<span class="toc-text">' + item.title + '</span></a>  </li>'
                })(i)
            }
            $("#catlist").html(templates)
        });
    }

</script>
<script src="http://cdn1.uibe-iup.com/scrollspy.min.js"></script>
<script src="js/prism.js"></script>
</body>
</html>