/**
 * Created by User on 8/3/2017.
 */
app.controller('galleryCtrl', ['$scope', '$http', //scope = model for angular, http = object used for http transactions
    function ($scope, $http) {
        $('.lightSlider').lightSlider({
            gallery: true,
            item: 1,
            loop: true,
            slideMargin: 0,
            thumbItem: 5
        });
        $(document).ready(function () {
            $(".internal-gallery").hide();
            $(".close-internal").hide();
            $('.expandable').on('click', function () {
                if (!$(this).hasClass('active')) {
                    $("h1").fadeOut().hide();
                    $this = $(this);
                    $this.addClass('active');
                    $this.find(".internal-gallery").hide().fadeIn(1000);
                    if ($this.hasClass('left')) {
                        $("#right-container").fadeOut(1000);
                        if ($('#left-container > :not(.active)').length) {
                            $('#left-container > :not(.active)').fadeOut(1000, function () {
                                $("#left-container").stop().animate({
                                    width: "100%"
                                }, 1000, function () {
                                    $this.stop().animate({
                                        height: "100%"
                                    }, 1000, function () {
                                        $this.find("ul").hide().fadeIn(1000, function () {
                                            $(window).trigger('resize');
                                        });
                                        $this.find(".close-internal").hide().fadeIn(function () {
                                            $(window).trigger('resize');
                                        });

                                    });
                                });
                            });
                        }
                        else{
                            $('#left-container > :not(.active)').fadeOut(1000, function () {
                                $("#left-container").stop().animate({
                                    width: "100%"
                                }, 1000, function () {
                                    $this.stop().animate({
                                        height: "100%"
                                    }, 1000, function () {
                                        $this.find("ul").hide().fadeIn(1000);
                                        $this.find(".close-internal").hide().fadeIn();
                                        $(window).trigger('resize');
                                    });
                                });
                            });
                        }
                    }
                    else{
                        $("#left-container").fadeOut(1000, function () {
                            $("#right-container").css({"margin-left": "61.5%"});
                            if ($('#right-container > :not(.active)').length) {
                                $('#right-container > :not(.active)').fadeOut(1000, function () {
                                    $("#right-container").stop().animate({
                                        width: "100%",
                                        marginLeft: "0"
                                    }, 1000, function () {
                                        $this.stop().animate({
                                            height: "100%"
                                        }, 1000, function () {
                                            $this.find("ul").hide().fadeIn(1000);
                                            $this.find(".close-internal").hide().fadeIn(1000);
                                            $(window).trigger('resize');
                                        });
                                    });

                                });
                            }
                            else{
                                $("#right-container").stop().animate({
                                    width: "100%",
                                    marginLeft: "0"
                                }, 1000, function () {
                                    $this.stop().animate({
                                        height: "100%"
                                    }, 1000, function () {
                                        $this.find("ul").hide().fadeIn(1000);
                                        $this.find(".close-internal").hide().fadeIn(1000);
                                        $(window).trigger('resize');
                                    });
                                });

                            }
                        });

                    }
                }

            });
            $(".close-internal").on('click', function () {
                $this.find(".close-internal").fadeOut();
                $this.find("ul").hide();
                if ($(".active").hasClass("right")) {
                    $(".expandable.active").stop().animate({
                        height: '92%'
                    }, 1000, function () {
                        $("#right-container").stop().animate({
                            width: '38.5%',
                            marginLeft: '58.5%'
                        }, 1000, function () {
                            $("#right-container").css({marginLeft: '0'});
                            if ($('#right-container > :not(.active)').length) {
                                $('#right-container > :not(.active)').hide().fadeIn();
                                $("#left-container").hide().fadeIn();
                            }
                            else{
                                $("#left-container").hide().fadeIn();

                            }
                            $("h1").hide().fadeIn();
                            $(".expandable").removeClass('active');
                            $(".internal-gallery").fadeOut();
                            $(".close-internal").fadeOut();

                        });
                    });
                }
                else {
                    $(".expandable.active").stop().animate({
                        height: '46%'
                    }, 1000, function () {
                        $("#left-container").stop().animate({
                            width: '58.5%',
                        }, 1000, function () {
                            if ($('#left-container > :not(.active)').length) {
                                $('#left-container > :not(.active)').hide().fadeIn();
                                $("#right-container").hide().fadeIn();

                            }
                            else{
                                $("#right-container").hide().fadeIn();
                            }

                            $("h1").hide().fadeIn();
                            $(".expandable").removeClass('active');
                            $(".internal-gallery").fadeOut();
                            $(".close-internal").fadeOut();

                        });
                    });
                }
            });
        });
    }
]);
/*
this needs to hide the background image of a gallery, expand horizontally, expand vertically
then the internal gallery fades
 */