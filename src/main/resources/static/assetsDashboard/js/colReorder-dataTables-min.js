/*! DataTables styling wrapper for ColReorder
 * © SpryMedia Ltd - datatables.net/license
 */
!function (n) {
    var o, d;
    "function" == typeof define && define.amd ? define(["jquery", "datatables.net-dt", "datatables.net-colreorder"], function (e) {
        return n(e, window, document)
    }) : "object" == typeof exports ? (o = require("jquery"), d = function (e, t) {
        t.fn.dataTable || require("datatables.net-dt")(e, t), t.fn.dataTable.ColReorder || require("datatables.net-colreorder")(e, t)
    }, "undefined" != typeof window ? module.exports = function (e, t) {
        return e = e || window, t = t || o(e), d(e, t), n(t, 0, e.document)
    } : (d(window, o), module.exports = n(o, window, window.document))) : n(jQuery, window, document)
}(function (e, t, n, o) {
    "use strict";
    return e.fn.dataTable
});