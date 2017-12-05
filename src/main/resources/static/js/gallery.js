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
                    if ($this.hasClass('left')) {
                        $("#right-container").fadeOut(1000, "swing").hide();
                    }
                }

                /*
                 if (!$(this).hasClass('active')) {
                    $("h1").fadeOut().hide();
                    $this = $(this);
                    $this.addClass('active');
                    if ($this.hasClass('right')) {
                        $("#left-container").stop().animate({
                            height: '0'
                        }, 1000, function () {
                            $("#left-container").hide();
                            if ($('#right-container > :not(.active)').length) {
                                $('#right-container > :not(.active)').stop().animate({
                                    height: '0'
                                }, 1000, function () {
                                    $("#right-container").css({marginLeft: '61.5%'});
                                    $("#right-container").stop().animate({
                                        width: '100%',
                                        marginLeft: 0
                                    }, 1000, function () {
                                        $this.stop().animate({
                                            height: '100%'
                                        }, 1000, function () {
                                            $this.find(".internal-gallery").hide().fadeIn();
                                            $this.find(".close-internal").hide().fadeIn();
                                        });

                                    });
                                });
                            }
                            else {
                                $("#right-container").css({marginLeft: '61.5%'});
                                $("#right-container").stop().animate({
                                    width: '100%',
                                    marginLeft: 0
                                }, 1000, function () {
                                    $this.stop().animate({
                                        height: '100%'
                                    }, 1000, function () {
                                        $this.find(".internal-gallery").hide().fadeIn();
                                        $this.find(".close-internal").hide().fadeIn();
                                    });

                                });
                            }
                        });

                    }
                    else {
                        $("#right-container").stop().animate({
                            height: '0'
                        }, 1000, function () {
                            $("#right-container").hide();
                            if ($('#left-container > :not(.active)').length) {
                                $('#left-container > :not(.active)').stop().animate({
                                    height: '0'
                                }, 1000, function () {
                                    $("#left-container").stop().animate({
                                        width: '100%',
                                        height: '100%'
                                    }, 1000, function () {
                                        $this.stop().animate({
                                            height: '100%'
                                        }, 1000, function () {
                                            $this.find(".internal-gallery").hide().fadeIn();
                                            $this.find(".close-internal").hide().fadeIn();
                                        });

                                    });
                                });
                            }
                            else {
                                $("#left-container").stop().animate({
                                    width: '100%',
                                    height: '100%'
                                }, 1000, function () {
                                    $this.stop().animate({
                                        height: '100%'
                                    }, 1000, function () {
                                        $this.find(".internal-gallery").hide().fadeIn();
                                        $this.find(".close-internal").hide().fadeIn();
                                    });

                                });
                            }

                        });
                          }
                           }
                 */




            });
            $(".close-internal").on('click', function () {
                $(".internal-gallery").fadeOut();
                $(".close-internal").fadeOut();
                if ($(this).hasClass("right")) {
                    $("#left-container").hide().show();
                    $(".expandable.active").stop().animate({
                        height: '92%'
                    }, 1000, function () {
                        $("#right-container").stop().animate({
                            width: '38.5%',
                            marginLeft: '61.5%'
                        }, 1000, function () {
                            $("#right-container").css({marginLeft: '0'});
                            if ($('#right-container > :not(.active)').length) {
                                $('#right-container > :not(.active)').stop().animate({
                                    height: '92%'
                                }, 1000, function () {
                                    $("#left-container").stop().animate({
                                        height: "100%"
                                    }, 1000, function () {
                                        $("h1").hide().fadeIn();
                                    });
                                    $(".expandable").removeClass('active');
                                });
                            }
                            else {
                                $("#left-container").stop().animate({
                                    height: "100%"
                                }, 1000, function () {
                                    $("h1").hide().fadeIn();
                                });
                                $(".expandable").removeClass('active');
                            }

                        });
                    });
                }
                else {
                    $("#right-container").hide().show();
                    $(".expandable.active").stop().animate({
                        height: '46%'
                    }, 1000, function () {
                        $("#left-container").stop().animate({
                            width: '58.5%'
                        }, 1000, function () {
                            if ($('#left-container > :not(.active)').length) {
                                $('#left-container > :not(.active)').stop().animate({
                                    height: '46%'
                                }, 1000, function () {
                                    $("#right-container").stop().animate({
                                        height: "100%"
                                    }, 1000, function () {
                                        $("h1").hide().fadeIn();
                                    });
                                    $(".expandable").removeClass('active');
                                });
                            }
                            else {
                                $("#right-container").stop().animate({
                                    height: "100%"
                                }, 1000, function () {
                                    $("h1").hide().fadeIn();
                                });
                                $(".expandable").removeClass('active');
                            }
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