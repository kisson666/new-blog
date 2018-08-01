var util = {
    now: function () {
        return (new Date()).getTime();
    },
    lasttime: 0,
    deltaTime: function () {
        var nowtime = util.now();
        var ans = nowtime - util.lasttime;
        util.lasttime = nowtime;
        //	console.log(ans);
        return ans;
    },
    randfloat: function (l, r) {//	[)
        return (Math.random() * (r - l) + l);
    },
    randint: function (l, r) {//	[)
        return Math.floor(util.randfloat(l, r));
    }

}
var canvasheight = 2000;
var canvaswidth = 2000;
var lightnum = 200;
var limit = 100;
var height, width;
var canvas;
var pointClass = {
    createNew: function () {
        ans = {};
        ans.x = util.randfloat(0, canvaswidth);
        ans.y = util.randfloat(0, canvasheight);
        var sita = util.randint(0, 2 * Math.PI);
        ans.vx = Math.cos(sita) * 0.03;
        ans.vy = Math.sin(sita) * 0.03;
        ans.fix = function () {
            if (this.x < 0 || this.x > canvaswidth) {
                this.vx = -this.vx;
                if (this.x < 0) this.x = 0;
                if (this.x > canvaswidth) this.x = canvaswidth;
            }
            if (this.y < 0 || this.y > canvasheight) {
                this.vy = -this.vy;
                if (this.y < 0) this.y = 0;
                if (this.y > canvaswidth) this.y = canvaswidth;
            }
        }
        ans.go = function (delta) {
            //	delta*=0.001;
            this.x += this.vx * delta;
            this.y += this.vy * delta;
        }
        return ans;
    },
    __le__: function (a, b) {
        return a.x - b.x;
    }
}
var points = new Array(lightnum);

function pointsSort() {
    points.sort(pointClass.__le__);
}

function pointsGo(delta) {
    for (var i = 0; i < lightnum; i++) {
        points[i].go(delta);
        points[i].fix();
    }
}

function display() {
    function clear() {
        canvas.fillStyle = '#000000';
        canvas.fillRect(0, 0, canvaswidth, canvasheight);
    }

    function drawPoints() {
        canvas.fillStyle = "#ffffff";
        canvas.lineWidth = 1;
        for (var i = 0; i < lightnum; i++) {
            canvas.beginPath();
            canvas.arc(points[i].x, points[i].y, util.randfloat(1, 2), 0, 2 * Math.PI);
            canvas.stroke();
            canvas.fill();
        }
    }

    function drawLines() {
        function distance(a, b) {
            var pow = Math.pow;
            return pow(pow(a.x - b.x, 2) + pow(a.y - b.y, 2), 0.5);
        }

        canvas.strokeStyle = '#42468f';
        //	canvas.lineWidth=20;
        for (var i = 0; i < lightnum; i++) {
            var pa = points[i];
            for (var j = i + 1; j < lightnum; j++) {
                pb = points[j];
                if (distance(pa, pb) <= limit) {
                    canvas.beginPath();
                    canvas.moveTo(pa.x, pa.y);
                    canvas.lineTo(pb.x, pb.y);
                    canvas.stroke();
                }
            }
        }
    }

    clear();
    drawPoints();
    drawLines();
}

function Init() {
    util.lasttime = util.now();
    for (var i = 0; i < lightnum; i++) {
        points[i] = pointClass.createNew();
    }
    canvas = $('.background')[0].getContext('2d');
}

function main() {
    height = $(window).height();
    width = $(window).width();
    pointsGo(util.deltaTime());
    //pointsSort();
    display();
}

$(document).ready(function () {
    Init();
    var start = setInterval('main()', 25);
});
