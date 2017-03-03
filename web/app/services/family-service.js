
import Ember from 'ember';
import Family from 'web/models/family';
import ListResult from 'web/models/listResult';


export default Ember.Service.extend({
  client: Ember.inject.service('client'),
  search:function(){
    const client = this.get('client');
    let results = ListResult.create({childType:Family});

    let searchUrl = '/auditioner/families';

    client.getResource(searchUrl,results);

    return results;
  },
  loadById:function(familyId)
  {
    const client = this.get('client');
    const url = '/auditioner/families' + familyId;

    const family = Family.create();

    family.set('client',client);
    family.set('path',url);

    client.getResource(url,family);

    return family;
  },
  deleteFamily:function(family)
  {
    const client = this.get('client');

    return client.deleteResource(family);
  },
  createFamily:function()
  {
    const client = this.get('client');
    const family = Family.create();
    family.set('client',client);
    return family;
  }

});
