<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title><#if article.title??>${article.title}</#if> | 别忘了微笑</title>
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
    <link rel="stylesheet" href="../../css/style.css">
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
            <nav id="nav-inner" class="nav-inner"><a class="nav-item" href="../../index.html"><span
                            class="nav-text">首页</span> </a><a class="nav-item"
                                                              href="../../categories/front-end/index.html"><span
                            class="nav-text">前端</span> </a><a class="nav-item"
                                                              href="../../categories/back-end/index.html"><span
                            class="nav-text">后端</span> </a><a class="nav-item" href="../../tags/index.html"><span
                            class="nav-text">标签</span> </a><a class="nav-item" href="../../archives/index.html"><span
                            class="nav-text">归档</span> </a><a class="nav-item" href="../../atom.xml"><span
                            class="nav-text">订阅</span> </a><a class="nav-item" href="../../about/index.html"><span
                            class="nav-text">关于</span></a></nav>
        </div>
        <aside id="aside" class="aside">
            <div id="aside-mask" class="aside-mask"></div>
            <div id="aside-inner" class="aside-inner">
                <form action="https://google.com/search" method="get" accept-charset="UTF-8" class="search-form">
                    <input type="search" name="q" class="search-form-input" placeholder="Search">
                    <button type="submit" class="search-form-submit"><i class="icon-search-stroke"></i></button>
                    <input type="hidden" name="sitesearch" value="https://sanonz.github.io"></form>
                <ol class="toc">
                    <#list articleVoList as item>

                        <#if item.articleSource.uuid?c == article.articleSource.uuid?c>
                            <li class="toc-item toc-level-2 active"><a class="toc-link"
                                                                       href="/post/${item.articleSource.uuid?c}">
                                    <span class="toc-text"> ${item.title}</span></a>
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

</main>
<script src="/webjars/jquery/2.1.1/jquery.js"></script>
<script src="http://cdn1.uibe-iup.com/scrollspy.min.js"></script>
<script src="js/prism.js"></script>
</body>
</html>