public class Queries {
   // ACCESO
    static String acceso = "SELECT puesto FROM empleados WHERE nom_usr = '%s' AND nip = '%s' AND estadoe = 'activo'";

    static String codigo_acceso = "SELECT codigo FROM empleados WHERE nom_usr = '%s' AND nip = '%s' AND estadoe = 'activo'";

    static String nombre_empleado = "SELECT nombree FROM empleados WHERE codigo = '%s'";

    //-----------------------------------------------------------------------------------------------------------------------------------------
    // GERENTE (administrador)
    static String empleados_buscar = "SELECT * FROM empleados WHERE nombree LIKE '%%%s%%' ORDER BY nombree";

    static String siguiente_idalimento = "SELECT IFNULL(MAX(idalimentos),0)+1 FROM alimentos";

    static String foto_alimento = "SELECT foto FROM alimentos WHERE idalimentos = ?";

    //-----------------------------------------------------------------------------------------------------------------------------------------
    // MESERO
    static String ordenes_mesero = "SELECT * FROM ordenes WHERE empleados_codigo_mesero = '%s' ORDER BY folio DESC";

    static String siguiente_folio = "SELECT IFNULL(MAX(folio),0)+1 FROM ordenes";

    static String clientes_combo = "SELECT CONCAT(codigoc,' - ',nombrec) FROM clientes ORDER BY codigoc";

    static String alimentos_combo = "SELECT CONCAT(idalimentos,' - ',nombre) FROM alimentos ORDER BY idalimentos";

    static String cocineros_combo = "SELECT CONCAT(codigo,' - ',nombree) FROM empleados WHERE puesto = 'cocinero' AND estadoe = 'activo' ORDER BY codigo";

    static String capacidad_mesa = "SELECT capacidad FROM mesas WHERE numero = %s";

    // Vista pedidos (FMesero): los filtros se unen con AND en la ventana
    static String pedidos_vista = "SELECT * FROM pedidos";

    static String pedidos_por_mesero = "empleados_codigo_mesero = '%s'";

    static String pedidos_por_estado = "estadoo = '%s'";

    static String pedidos_por_mesa = "mesas_numero = %s";

    //-----------------------------------------------------------------------------------------------------------------------------------------
    // CAJERO
    static String ordenes_todas = "SELECT * FROM ordenes ORDER BY folio DESC";

    static String orden_folio = "SELECT * FROM ordenes WHERE folio = %s";

    // Vista ticket (FCajero): ordenes entregadas, pendientes de cobro
    static String ticket_todos = "SELECT * FROM ticket ORDER BY folio";

    static String ticket_mesa = "SELECT * FROM ticket WHERE mesas_numero = %s ORDER BY folio";

    static String ticket_total = "SELECT IFNULL(SUM(precio),0) FROM ticket";

    static String ticket_total_mesa = "SELECT IFNULL(SUM(precio),0) FROM ticket WHERE mesas_numero = %s";

    // Vista pedidos (FCajero): todas las ordenes sin importar su estado
    static String pedidos_todos = "SELECT * FROM pedidos ORDER BY folio DESC";

    //-----------------------------------------------------------------------------------------------------------------------------------------
    // COCINERO
    static String ordenes_cocinero = "SELECT * FROM ordenes WHERE empleados_codigo_cocinero = '%s' AND estadoo IN ('ordenado','preparando') ORDER BY folio";

    // Vista comandas (FCocinero): ordenes 'ordenado' del dia, ya vienen ordenadas por hora
    static String comandas_todas = "SELECT * FROM comandas ORDER BY fecha_hora";

    static String comandas_folio = "SELECT * FROM comandas WHERE folio = %s ORDER BY fecha_hora";
    //-----------------------------------------------------------------------------------------------------------------------------------------
}
