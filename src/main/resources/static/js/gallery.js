/**
 * Created by User on 8/3/2017.
 */
app.controller('galleryCtrl', ['$scope', '$http', //scope = model for angular, http = object used for http transactions
    function ($scope, $http) {
        $scope.photoList = null;
        $scope.groups = null;
        $scope.sections = null;
        var newSectionPic = null;
        $scope.newSectionTitle = null;
        $scope.newSectionText = null;

        $scope.loadEditData = function () {
            var url = "http://" + window.location.hostname + "/admin/galleryGroups";
            $http.get(url).success(
                function (response) {
                    $scope.groups = response;
                }
            );
            url = "http://" + window.location.hostname + "/admin/gallerySections";
            $http.get(url).success(
                function (response) {
                    $scope.sections = response;
                }
            );
            url = "http://" + window.location.hostname + "/admin/photoList";
            $http.get(url).success(
                function (response) {
                    $scope.photoList = response;
                }
            );
        };

        $scope.deleteGroup = function (id) {
            var url = "http://" + window.location.hostname + "/admin/deleteGroup?group=" + id;
            var result = confirm("Are you sure? Any changes you have made will go live on the site.");
            if (result) {
                $http.get(url).success(
                    function () {
                        alert("Your changes to gallery page have gone live");
                        window.location.reload();
                    }
                );
            }
        };

        $scope.deleteSection = function (id) {
            var url = "http://" + window.location.hostname + "/admin/deleteSection?section=" + id;
            var result = confirm("Are you sure? Any changes you have made will go live on the site.");
            if (result) {
                $http.get(url).success(
                    function () {
                        alert("Your changes to gallery page have gone live");
                        window.location.reload();
                    }
                );
            }
        };

        $scope.selectGroupSection1 = function (section, group) {
            group.section1 = section;
        };
        $scope.selectGroupSection2 = function (section, group) {
            group.section2 = section;
        };
        $scope.selectGroupSection3 = function (section, group) {
            group.section3 = section;
        };

        $scope.newGroup = function () {
            var url = "http://" + window.location.hostname + "/admin/newGroup";
            $http.get(url).success(
                function () {
                    window.location.reload();
                }
            );
        };

        $scope.newSection = function () {
            var url = "http://" + window.location.hostname + "/admin/newSection?title="+$scope.newSectionTitle+"&text="+$scope.newSection;
            $http.get(url).success(
                function () {
                    window.location.reload();
                }
            );
        };

        $scope.saveGroup = function (group) {
            var url = "http://" + window.location.hostname + "/admin/saveGroup";
            $http.post(url, group).success(
                function () {
                    window.location.reload();
                }
            );
        };

        $scope.saveSection = function (section) {
            var url = "http://" + window.location.hostname + "/admin/saveSection";
            $http.post(url, section).success(
                function () {
                    window.location.reload();
                }
            );
        };

        $scope.removePhoto = function (photo, section) {
            var index = section.photos.indexOf(photo);
            if (index > -1) {
                section.photos.splice(index, 1);
            }
        };

        $scope.selectSectionPic = function (photo,section,index){
            section.photos[index] = photo;
        };
        $scope.selectNewSectionPic = function (photo) {
            newSectionPic = photo;
        };

        $scope.addSectionPic = function (section) {
            section.photos.push(newSectionPic);
        };

        $(document).ready(function () {  //this is a monster of a method @jackson
            $(".internal-gallery").hide();
            $(".close-internal").hide();
            var activeSlider;
            $('.expandable').on('click', function () {
                if (!$(this).hasClass('active')) {
                    $("h1").fadeOut().hide();
                    $this = $(this);
                    $this.addClass('active');
                    $currentContainer = $this.parent();
                    $currentGroup = $currentContainer.parent();
                    $currentGroup.scrollTop($currentGroup.scrollHeight - $currentGroup[0].clientHeight);
                    $this.find('.lightSlider').hide();
                    $this.find(".internal-gallery").hide().fadeIn(1000);
                    if ($this.hasClass('left')) {
                        $currentGroup.find(".right-container").fadeOut(1000);
                        if ($this.hasClass("first-left")) {
                            $currentContainer.find('.second-left').fadeOut(1000, function () {
                                $currentContainer.stop().animate({
                                    width: "98%"
                                }, 1000, function () {
                                    $this.stop().animate({
                                        height: "100%"
                                    }, 1000, function () {
                                        $this.find("ul").hide().show();
                                        $this.find(".close-internal").hide().show();
                                        $(window).trigger('resize');
                                        if (!$this.find(".lightSlider").hasClass("created")) {
                                            $this.find('.lightSlider').lightSlider({
                                                gallery: true,
                                                item: 1,
                                                loop: true,
                                                slideMargin: 0,
                                                thumbItem: 25,
                                                adaptiveHeight: true,
                                                responsive : [
                                                    {
                                                        breakpoint: 800,
                                                        settings: {
                                                            thumbItem: 18
                                                        }
                                                    },
                                                    {
                                                        breakpoint: 540,
                                                        settings:{
                                                            thumbItem: 10
                                                        }
                                                    }
                                                ]
                                            });
                                            $this.find(".lightSlider").addClass("created");
                                        }
                                        $(window).trigger('resize');
                                    });
                                });
                            });
                        }
                        else {
                            $currentContainer.find('.first-left').animate({
                                height: "0"
                            }, 1000, function () {
                                $this.stop().animate({
                                    height: "100%"
                                }, 1000, function () {
                                    $currentContainer.stop().animate({
                                        width: "98%"
                                    }, 1000, function () {
                                        $this.find("ul").hide().show();
                                        $this.find(".close-internal").hide().show();
                                        $(window).trigger('resize');
                                        if (!$this.find(".lightSlider").hasClass("created")) {
                                            $this.find('.lightSlider').lightSlider({
                                                gallery: true,
                                                item: 1,
                                                loop: true,
                                                slideMargin: 0,
                                                thumbItem: 25,
                                                adaptiveHeight: true,
                                                responsive : [
                                                    {
                                                        breakpoint: 800,
                                                        settings: {
                                                            thumbItem: 18
                                                        }
                                                    },
                                                    {
                                                        breakpoint: 540,
                                                        settings:{
                                                            thumbItem: 10
                                                        }
                                                    }
                                                ]
                                            });
                                            $this.find(".lightSlider").addClass("created");
                                        }
                                        $(window).trigger('resize');
                                    });
                                });
                            });
                        }
                    }
                    else {
                        $currentGroup.find(".left-container").fadeOut(1000, function () {
                            $currentContainer.css({"margin-left": "61.5%"});
                            $currentContainer.stop().animate({
                                width: "99%",
                                marginLeft: "0"
                            }, 1000, function () {
                                $this.stop().animate({
                                    height: "100%"
                                }, 1000, function () {
                                    $this.find("ul").hide().show();
                                    $this.find(".close-internal").hide().show();
                                    $(window).trigger('resize');
                                    if (!$this.find(".lightSlider").hasClass("created")) {
                                        $this.find('.lightSlider').lightSlider({
                                            gallery: true,
                                            item: 1,
                                            loop: true,
                                            slideMargin: 0,
                                            thumbItem: 25,
                                            adaptiveHeight: true,
                                            responsive : [
                                                {
                                                    breakpoint: 800,
                                                    settings: {
                                                        thumbItem: 18
                                                    }
                                                },
                                                {
                                                    breakpoint: 540,
                                                    settings:{
                                                        thumbItem: 10
                                                    }
                                                }
                                            ]
                                        });
                                        $this.find(".lightSlider").addClass("created");
                                    }
                                    $(window).trigger('resize');
                                });
                            });
                        });
                    }
                }
            });
            $(".close-internal").on('click', function () {
                $this = $(this).parent().parent();
                $currentContainer = $this.parent();
                $currentGroup = $currentContainer.parent();
                $this.find(".close-internal").fadeOut();
                $this.find("ul").hide();
                if ($this.hasClass("right")) {
                    $this.stop().animate({
                        height: '94%'
                    }, 1000, function () {
                        $currentContainer.stop().animate({
                            width: '38.5%',
                            marginLeft: '58.5%'
                        }, 1000, function () {
                            $currentContainer.css({marginLeft: '0'});
                            $this.find(".internal-gallery").fadeOut();
                            $currentGroup.find(".left-container").hide().fadeIn();
                            $this.find(".close-internal").fadeOut();
                            $("h1").hide().fadeIn();
                            $this.removeClass('active');
                        });
                    });
                }
                else {
                    if ($this.hasClass("first-left")) {
                        $this.stop().animate({
                            height: '46%'
                        }, 1000, function () {
                            $currentContainer.stop().animate({
                                width: '58.5%',
                            }, 1000, function () {
                                $currentContainer.find('.second-left').hide().fadeIn();
                                $currentGroup.find(".right-container").hide().fadeIn();
                                $("h1").hide().fadeIn();
                                $this.removeClass('active');
                                $this.find(".internal-gallery").fadeOut();
                                $this.find(".close-internal").fadeOut();
                            });
                        });
                    }
                    else {
                        $currentContainer.stop().animate({
                            width: '58.5%'
                        }, 1000, function () {
                            $currentContainer.find(".first-left").css({"opacity": "0"}).animate({height: "46%"}, 1000).animate({opacity: "1"});
                            $this.stop().animate({
                                height: '46%'
                            }, 1000, function () {
                                $currentGroup.find(".right-container").hide().fadeIn();
                                $("h1").hide().fadeIn();
                                $this.removeClass('active');
                                $this.find(".internal-gallery").fadeOut();
                                $this.find(".close-internal").fadeOut();

                            });
                        });
                    }
                }
            });
        });
    }
]);
/*
this needs to hide the background image of a gallery, expand horizontally, expand vertically
then the internal gallery fades
 */
