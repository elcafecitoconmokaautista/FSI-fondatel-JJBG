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

    //-----------------------------------------------------------------------------------------------------------------------------------------
    // CAJERO
    static String ordenes_todas = "SELECT * FROM ordenes ORDER BY folio DESC";

    static String orden_folio = "SELECT * FROM ordenes WHERE folio = %s";

    //-----------------------------------------------------------------------------------------------------------------------------------------
    // COCINERO
    static String ordenes_cocinero = "SELECT * FROM ordenes WHERE empleados_codigo_cocinero = '%s' AND estadoo IN ('ordenado','preparando') ORDER BY folio";
    //-----------------------------------------------------------------------------------------------------------------------------------------
}
