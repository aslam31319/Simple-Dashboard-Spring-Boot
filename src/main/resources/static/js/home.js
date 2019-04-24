$(document).ready(
    function() {
        $("#SwitchD").click(function() {
            if ($(this).val() == "Show Table") {
                $(this).val("Show Dash Board");

                $("#containerchart").fadeOut();
                $("#example_wrapper").fadeIn();
                $("#example").fadeIn();
                

            } else {
                $(this).val("Show Table");
                $("#example").fadeOut();
                $("#example_wrapper").fadeOut();
                $("#containerchart").fadeIn();
            }

        });

        $("#PDF").click(function() {
            $("#filetype").val("PDF");
            $("#downloadlink").attr("href", "download?fileEXT=PDF");
        });
        $("#pdfli").click(function() {
            $("#filetype").val("PDF");
            $("#downloadlink").attr("href", "download?fileEXT=PDF");
        });
        $("#XLSX").click(function() {
            $("#filetype").val("XLSX");
            $("#downloadlink").attr("href", "download?fileEXT=XLSX");
        });
        $("#xlsxli").click(function() {
            $("#filetype").val("XLSX");
            $("#downloadlink").attr("href", "download?fileEXT=XLSX");
        });
        $("#CSV").click(function() {
            $("#filetype").val("CSV");
            $("#downloadlink").attr("href", "download?fileEXT=CSV");
        });
        $("#csvli").click(function() {
            $("#filetype").val("CSV");
            $("#downloadlink").attr("href", "download?fileEXT=CSV");
        });
        // data table
        $('#example').DataTable(
                {
                    dom : "<'row'<'col-sm-4'l><'col-sm-8'f>>"
                            + "<'row'<'col-sm-12'tr>>"
                            + "<'row'<'col-sm-4'B><'col-sm-8'p>>",
                    buttons : [ 'copy', 'excel', 'pdf' ],
                    lengthMenu: [ 5,10, 25, 50 ],
                    pageLength : 5,
                    ajax : {
                        url : "getallemp",
                        dataSrc : '',
                        type : "POST"
                    },
                    columns : [ {
                        data : "id"
                    }, {
                        data : "name"
                    }, {
                        data : "office"
                    }, {
                        data : "position"
                    }, {
                        data : "salary"
                    }, ]
                });

        $("#emailbtn").click(function() {
            $.ajax({
                url : "mailAttach",
                type : "POST",
                data : {
                    "fileEXT" : $("#filetype").val(),
                    "email" : $("#useremail").val()
                },
                error : function() {
                    alert("Some thing went Wrog");
                },
                success : function() {
                    alert("email send");
                }
            });
        });
    });
$(document).ready(function() {

});
var chart1 = c3.generate({
bindto : '#lineChart',
data : {
    size : {
        height : 140,
        width : 280
    },
    x : 'x',
    columns : [ [ 'x', '2013', '2014', '2015', '2016', '2017', '2018' ],
            [ 'Development', 30, 200, 100, 400, 150, 250 ],
            [ 'Testing', 50, 20, 10, 40, 15, 25 ] ],
    type : 'line'
},
/*
 * axes: { Development: 'y2' // ADD },
 */
axis : {
    x : {
        type : 'category',
        tick : {
            categories : [ '2013', '2014', '2015', '2016', '2017', '2018' ]
        }
    }
}

});

var chart2 = c3.generate({
bindto : '#barChart',
data : {
    x : 'x',
    columns : [ [ 'x', '2013', '2014', '2015', '2016', '2017', '2018' ],
            [ 'Development', 30, 200, 100, 400, 150, 250 ],
            [ 'Testing', 130, 100, 140, 200, 150, 50 ] ],

    type : 'bar'
},
bar : {
    width : {
        ratio : 0.5
    // this makes bar width 50% of length between ticks
    },
    axis : {
        x : {
            type : 'category',
            tick : {
                categories : [ '2013', '2014', '2015', '2016', '2017',
                        '2018' ]
            }
        }
    }
// or
// width: 100 // this makes bar width 100px
}
});
var chart3 = c3.generate({
bindto : '#pieChart',
data : {
    // iris data from R
    columns : [ [ 'Development', 15 ], [ 'Testing', 12 ], ],
    type : 'pie',
    onclick : function(d, i) {
        console.log("onclick", d, i);
    },
    onmouseover : function(d, i) {
        console.log("onmouseover", d, i);
    },
    onmouseout : function(d, i) {
        console.log("onmouseout", d, i);
    }
}
});

var chart4 = c3.generate({
bindto : '#donutChart',
data : {
    columns : [ [ 'Development', 15 ], [ 'Testing', 12 ], ],
    type : 'donut',
    onclick : function(d, i) {
        console.log("onclick", d, i);
    },
    onmouseover : function(d, i) {
        console.log("onmouseover", d, i);
    },
    onmouseout : function(d, i) {
        console.log("onmouseout", d, i);
    }
},
donut : {
    title : "In Crors"
}
});

function generateScreenshot() {
html2canvas(document.body, {
    scale : 4,
    allowTaint : true
}).then(function(canvas) {
    saveAs(canvas.toDataURL(), 'canvas.png');
});
}

function saveAs(uri, filename) {
var link = document.createElement('a');
if (typeof link.download === 'string') {
    link.href = uri;
    link.download = filename;

    // Firefox requires the link to be in the body
    document.body.appendChild(link);

    // simulate click
    link.click();

    // remove the link when done
    document.body.removeChild(link);
} else {
    window.open(uri);
}
}