<div id="table-responsive">
    <p id="date_filter">
    <span id="date-label-from" class="date-label">Fecha Inicial: </span><input class="date_range_filter date" type="text" id="datepicker_from" />
    <span id="date-label-to" class="date-label">Fecha Final: <input class="date_range_filter date" type="text" id="datepicker_to" />
        </p>
        <table id="table_VentasArtistas" class="table table-striped table-advance table-hover">
            <thead>
                <tr>                                            
                    <th></th>
                    <th>Artista</th>
                    <th>Empresa</th>
                    <th>Total de Venta</th>
                    <th>Fecha de Venta</th>
                </tr>
            </thead>
            <tfoot>
                <tr>
                    <th></th>
                    <th>Artista</th>
                    <th>Empresa</th>
                    <th>Total de Venta</th>
                    <th>Fecha de Venta</th>
                </tr>
            </tfoot>
            <tbody id="employee_data">
        <span id="date-label-from" class="date-label">Fecha Inicial: <input class="date_range_filter date" type="text" id="datepicker_from" />
        <span id="date-label-to" class="date-label">Fecha Final: </span><input class="date_range_filter date" type="text" id="datepicker_to" />
         <button id="buscar_rangofecha" onclick="generarInformeRangoFecha();" class="btn btn-default" name="buscar_rangofecha">Buscar</button>
    </p>
    <table id="table_VentasArtistas" class="table table-striped table-advance table-hover">
        <thead>
            <tr>                                            
                <th></th>
                <th>Artista</th>
                <th>Empresa</th>
                <th>Total de Venta</th>
                <th>Fecha de Venta</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th></th>
                <th>Artista</th>
                <th>Empresa</th>
                <th>Total de Venta</th>
                <th>Fecha de Venta</th>
            </tr>
        </tfoot>
        <tbody id="employee_data">

            </tbody>
        </table>
</div>
<script src="../../js/DataTables/Info_TVentasArtistas.js" type="text/javascript"></script>