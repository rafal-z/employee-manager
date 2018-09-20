var gulp = require('gulp');
var watch = require('gulp-watch');
var batch = require('gulp-batch');
var del = require('del');
var concat = require('gulp-concat');
var merge = require('merge-stream');

var appDistDir = './../../webapp/app/';

gulp.task('watch', function () {
    watch(["app/**/*.html", "app/**/*.js", "app/**/*.css"], batch(function (events, done) {
        gulp.start('build-debug', done);
    }));
});

gulp.task('clean', function (callback) {
    return del([
        appDistDir + '**/*'
    ], {force: true});
});

gulp.task('create-js', function () {
    //                            ważna kolejność ładowania plików
    return gulp.src(["app/app.js","app/app.config.js","app/app.routes.js", "app/**/*.module.js","app/**/*.js"])
        .pipe(concat('app.js'))
        .pipe(gulp.dest(appDistDir));
});

// gulp.task('create-lib-js', function () {
//     return gulp.src('node_modules/**/*.js')
//         .pipe(concat('lib.js'))
//         .pipe(gulp.dest(appDistDir));
// });
//
// gulp.task('create-lib-css', function () {
//     return gulp.src('node_modules/**/*.css')
//         .pipe(concat('lib.css'))
//         .pipe(gulp.dest(appDistDir));
// });

gulp.task('create-css', function () {
    return gulp.src('app/**/*.css')
        .pipe(concat('app.css'))
        .pipe(gulp.dest(appDistDir));
});

gulp.task('copy-resources', function () {
    var appHtml = gulp.src(['app/**/*.html']).pipe(gulp.dest(appDistDir));
    var localeJSONs = gulp.src(['../locale-*.json']).pipe(gulp.dest(appDistDir));
    return merge(appHtml, localeJSONs);
});

gulp.task('copy-index', function () {
    return gulp.src(['app/index.html']).pipe(gulp.dest('./../../webapp/'));
});

gulp.task('build-debug', [
    'copy-index',
    'copy-resources',
    'create-js',
    // 'create-lib-css',
    // 'create-lib-js',
    'create-css'
]);