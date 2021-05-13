<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title><#if article.title??>${article.articleSource.dateadd}</#if> | 别忘了微笑</title>
    <meta name="author" content="">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
    <link rel="alternate" href="../../atom.xml" title="Sanonz" type="application/atom+xml">
    <link rel="icon" href="../../images/favicon.ico">
    <style type="text/css">@font-face {
            font-family: icomoon;
            src: url(../../fonts/icomoon%EF%B9%96q628ml.eot);
            src: url(../../fonts/icomoon%EF%B9%96q628ml.eot#iefix) format('embedded-opentype'), url(../../fonts/icomoon%EF%B9%96q628ml.ttf) format('truetype'), url(../../fonts/icomoon%EF%B9%96q628ml.woff) format('woff'), url(../../fonts/icomoon%EF%B9%96q628ml.svg#icomoon) format('svg');
            font-weight: 400;
            font-style: normal
        }</style>
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="http://cdn1.uibe-iup.com/prism.css">

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
    <script type="text/javascript" src="https://unpkg.com/html5shiv@3.7.3/dist/html5shiv.min.js"></script><![endif]-->
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
                        <li class="toc-item toc-level-2"><a class="toc-link" href="/post/${item.articleSource.uuid?c}">
                                <span class="toc-text"> ${item.title}</span></a>
                        </li>
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
                            <i class="icon-tag vm"></i>
                            <a class="article-tag-link"
                               href="../../tags/CI/index.html"
                               rel="tag">CI</a>

                        </div>
                    </div>
                </header>
                <section class="article-body markdown-body">
                    <#if article.content??>${article.content}</#if>
                </section>
            </article>
            <a id="pagenext" href="../to-build-dark-and-light-theme-with-web/index.html" class="article-next"
               title="在 WEB 端实现亮/暗主题跟随系统功能"><i class="icon-arrow-right"></i></a>
            <a id="pageprev"
               href="../make-hybrid-platform-cordova/index.html"
               class="article-prev"
               title="使用 Phonegap + Cordova 搭建混合开发平台"><i
                        class="icon-arrow-left"></i></a>
            <div class="comments">
                <div id="comments"></div>
                <script src="https://unpkg.com/gitalk/dist/gitalk.min.js"></script>
                <script>new Gitalk({
                        clientID: "2f728eb14f7e549408f7",
                        clientSecret: "90be74e913959dcf39fbfed54458bdd20f95ac30",
                        repo: "sanonz.github.io",
                        owner: "sanonz",
                        admin: ["sanonz"],
                        id: "f8b53398add9e549b019d8ef4b4b0fd4",
                        distractionFreeMode: !0,
                        title: "利用 Github Actions 自动部署 Hexo 博客",
                        body: "https://sanonz.github.io/2020/deploy-a-hexo-blog-from-github-actions/",
                        labels: ["Hexo", "CI", "Github Actions"]
                    }).render("comments")</script>
            </div>
        </div>
    </div>

</main>
<script src="http://cdn1.uibe-iup.com/scrollspy.min.js"></script>
<script src="http://cdn1.uibe-iup.com/prism.js"></script>
</body>
</html>