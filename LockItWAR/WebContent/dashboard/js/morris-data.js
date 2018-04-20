$(function() {

    Morris.Area({
        element: 'morris-area-chart',
        data: [{
            period: '2010 Q1',
            FDoor: 2666,
            BDoor: null,
            Windows: 2647
        }, {
            period: '2010 Q2',
            FDoor: 2778,
            BDoor: 2294,
            Windows: 2441
        }, {
            period: '2010 Q3',
            FDoor: 4912,
            BDoor: 1969,
            Windows: 2501
        }, {
            period: '2010 Q4',
            FDoor: 3767,
            BDoor: 3597,
            Windows: 5689
        }, {
            period: '2011 Q1',
            FDoor: 6810,
            BDoor: 1914,
            Windows: 2293
        }, {
            period: '2011 Q2',
            FDoor: 5670,
            BDoor: 4293,
            Windows: 1881
        }, {
            period: '2011 Q3',
            FDoor: 4820,
            BDoor: 3795,
            Windows: 1588
        }, {
            period: '2011 Q4',
            FDoor: 15073,
            BDoor: 5967,
            Windows: 5175
        }, {
            period: '2012 Q1',
            FDoor: 10687,
            BDoor: 4460,
            Windows: 2028
        }, {
            period: '2012 Q2',
            FDoor: 8432,
            BDoor: 5713,
            Windows: 1791
        }],
        xkey: 'period',
        ykeys: ['FDoor', 'BDoor', 'Windows'],
        labels: ['FDoor', 'BDoor', 'windows'],
        pointSize: 2,
        hideHover: 'auto',
        resize: true
    });

    Morris.Donut({
        element: 'morris-donut-chart',
        data: [{
            label: "Download Sales",
            value: 12
        }, {
            label: "In-Store Sales",
            value: 30
        }, {
            label: "Mail-Order Sales",
            value: 20
        }],
        resize: true
    });

    Morris.Bar({
        element: 'morris-bar-chart',
        data: [{
            y: '2006',
            a: 100,
            b: 90
        }, {
            y: '2007',
            a: 75,
            b: 65
        }, {
            y: '2008',
            a: 50,
            b: 40
        }, {
            y: '2009',
            a: 75,
            b: 65
        }, {
            y: '2010',
            a: 50,
            b: 40
        }, {
            y: '2011',
            a: 75,
            b: 65
        }, {
            y: '2012',
            a: 100,
            b: 90
        }],
        xkey: 'y',
        ykeys: ['a', 'b'],
        labels: ['Series A', 'Series B'],
        hideHover: 'auto',
        resize: true
    });

});
