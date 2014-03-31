/*
* Author: Hikmat Dhamee (me.hemant.available@gmail.com)
* Nginx JSON Module
*/

#include <nginx.h>
#include <ngx_core.h>
#include <ngx_config.h>
#include <ngx_http.h>

#define HW_CONTENT_TYPE "text/plain"

// declare functions
static ngx_int_t ngx_http_json_variable(ngx_http_request_t *r,ngx_http_variable_value_t *v, uintptr_t data);
static ngx_int_t ngx_http_json_add_variables(ngx_conf_t *cf);
static char *ngx_http_json_conf_handler( ngx_conf_t *cf,ngx_command_t *cmd, void *conf );


//declare directive json
static ngx_command_t ngx_http_json_commands[] = {
    { ngx_string("json"),
      NGX_HTTP_SRV_CONF|NGX_HTTP_LOC_CONF|NGX_CONF_FLAG,
      ngx_http_json_conf_handler,
      0,
      0,
      NULL },
      
    ngx_null_command
};

//declare callback function of nginx events
static ngx_http_module_t ngx_http_json_module_ctx = {
    ngx_http_json_add_variables, /* preconfiguration */
    NULL, /* postconfiguration */
 
    NULL, /* create main configuration */
    NULL, /* init main configuration */
 
    NULL, /* create server configuration */
    NULL, /* merge server configuration */
 
    NULL, /* create location configuration */
    NULL  /* merge location configuration */
};


//decalre ngx_http_json_module which is in config file
ngx_module_t ngx_http_json_module = {
    NGX_MODULE_V1,              /* nginx api version */
    &ngx_http_json_module_ctx,  /* module context */
    ngx_http_json_commands,     /* module directives */
    NGX_HTTP_MODULE,            /* module type */
    NULL, /* init master */
    NULL, /* init module */
    NULL, /* init process */
    NULL, /* init thread */
    NULL, /* exit thread */
    NULL, /* exit process */
    NULL, /* exit master */
    NGX_MODULE_V1_PADDING
};

// Array of variables to be created
static ngx_http_variable_t  ngx_http_json_vars[] = {

    { ngx_string("sparkngin_json"), NULL, ngx_http_json_variable,
      0, NGX_HTTP_VAR_NOCACHEABLE, 0 },
    { ngx_null_string, NULL, NULL, 0, 0, 0 }
};


//request handler
ngx_int_t ngx_http_json_handler(ngx_http_request_t *r){
    ngx_buf_t *b;
    ngx_chain_t out;
    ngx_int_t rc;

    static u_char szHelloMsg[] = "Hello World!" ;

    //set http header information
    r->headers_out.content_type.len = ngx_strlen( HW_CONTENT_TYPE ) ;
    r->headers_out.content_type.data = (u_char *)HW_CONTENT_TYPE ;
 

    r->headers_out.status = NGX_HTTP_OK;
    r->headers_out.content_length_n = sizeof( szHelloMsg ) - 1 ;

    //Add hello world message into a buf chain, and submit the chain to nginx.
    //Memory must be allocated from nginx pool. malloc and free are forbidden.
    b = ngx_pcalloc(r->pool, sizeof(ngx_buf_t));
    
    if(b == NULL){
        ngx_log_error( NGX_LOG_ERR, r->connection->log, 0, "Failed to allocate response buffer." );
        return NGX_HTTP_INTERNAL_SERVER_ERROR;
    }

    out.buf = b;
    out.next = NULL;
        
    b->pos = szHelloMsg ;
    b->last = szHelloMsg + sizeof( szHelloMsg ) - 1 ;

    b->memory = 1;
    b->last_buf = 1;

    rc = ngx_http_send_header(r);
  
    if(rc != NGX_OK){
        return rc;
    }

    return ngx_http_output_filter(r, &out);
}


// variable specific action
static ngx_int_t ngx_http_json_variable(ngx_http_request_t *r,ngx_http_variable_value_t *v, uintptr_t data){
    u_char            *p;
    u_char value[]="{'key':'value'}";

    p = ngx_pnalloc(r->pool, sizeof(value));
    if (p == NULL) {
        return NGX_ERROR;
    }
    
    /* data contains index a variable in declared variable list */
    switch (data){
        case 0:
          value ="hello" ;
          break;
        default:
          value = 0;
    }
    
    v->len = ngx_sprintf(p, "%s", value) - p;
    v->valid = 1;
    v->no_cacheable = 0;
    v->not_found = 0;
    v->data = p;

    return NGX_OK;
}

// add variables to nginx
static ngx_int_t ngx_http_json_add_variables(ngx_conf_t *cf){
    ngx_http_variable_t  *var, *v;

    for (v = ngx_http_json_vars; v->name.len; v++) {
        var = ngx_http_add_variable(cf, &v->name, v->flags);
        if (var == NULL) {
            return NGX_ERROR;
        }

        var->get_handler = v->get_handler;
        var->data = v->data;
    }

    return NGX_OK;
}

//directive handler
static char *ngx_http_json_conf_handler( ngx_conf_t *cf, ngx_command_t *cmd, void *conf ){
    ngx_http_core_loc_conf_t *clcf;

    clcf = ngx_http_conf_get_module_loc_conf( cf, ngx_http_core_module ) ;

    //specify request handler
    clcf->handler = ngx_http_json_handler ;

    return NGX_CONF_OK ;
}
